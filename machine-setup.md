Configuration for AWS server  
Ubuntu 18.04  
IP: 13.48.85.75  
To view actuator go: 13.48.85.75/api/actuator  
All of the commands are done on the server.  

**Login**  
ssh: ssh ubuntu@ec2-13-48-85-75.eu-north-1.compute.amazonaws.com

**Add ssh keys**  
cd ~/.ssh for every user (ubuntu is enough)  
nano authorized_keys, add the key  
sudo service ssh restart

**Add virtual memory**
sudo fallocate -l 3G /swapfile  
sudo chmod 600 /swapfile  
sudo mkswap /swapfile  
sudo swapon /swapfile  
echo '/swapfile none swap sw 0 0' | sudo tee -a /etc/fstab  

htop to check  
restart server and check whether virtual memory change was permanent  
sudo reboot

**Install Java**  
sudo apt-get update
sudo apt-get install openjdk-11-jre openjdk-11-jdk 

**Install gitlab-runner on your server and configure it**  

sudo curl -L --output /usr/local/bin/gitlab-runner https://gitlab-runner-downloads.s3.amazonaws.com/latest/binaries/gitlab-runner-linux-amd64  

give it permission to execute:  
sudo chmod +x /usr/local/bin/gitlab-runner

create a CI user:      
sudo useradd --comment 'GitLab Runner' --create-home gitlab-runner --shell /bin/bash

install and run service:      
sudo gitlab-runner install --user=gitlab-runner --working-directory=/home/gitlab-runner   
sudo gitlab-runner start   

register the runner:   
sudo gitlab-runner register   
1)Enter your GitLab instance URL  
2)Enter the token you obtained to register the Runner    
3)Add a description (left it blank)   
4)Add tags (added a tag: twentyone)   
5)Enter runner executor (shell)


**backend: define backend as linux service W9**    
*We assume that gitlab puts backend jar into /home/gitlab-runner/api-deployment*  
*We assume that jar is called twentyone.jar*


cd /etc/systemd/system/   
sudo touch twentyone.service   
sudo nano twentyone.service   

**COPY THIS TO THE FILE**

[Unit]
Description=twentyone backend service
After=network.target
[Service]
Type=simple   
User=gitlab-runner   
WorkingDirectory=/home/gitlab-runner/api-deployment   
ExecStart=/usr/bin/java -jar twentyone.jar   
Restart=on-abort   
[Install]
WantedBy=multi-user.target

**STOP COPYING HERE**

Configuration must be reloaded    
sudo systemctl daemon-reload   

Process must be enabled    
sudo systemctl enable twentyone 

Start the service  
sudo service twentyone restart  

To check backend use (or check your logfiles)      
sudo service twentyone status   

**Install node and yarn for gitlab runner to build frontend code**  
sudo curl -sL https://deb.nodesource.com/setup_12.x | sudo -E bash -   
sudo apt-get update   
sudo apt-get install nodejs   
sudo npm install -g yarn   

**Go to gitlab runner and make your frontend dir, register gitlab-runner for frontend**  
sudo su gitlab-runner   
cd /home/gitlab-runner/   
mkdir front-deployment   
exit   

just like before:   
sudo gitlab-runner register   
1)Enter your GitLab instance URL  
2)Enter the token you obtained to register the Runner    
3)Add a description (left it blank)   
4)Add tags (added a tag: twentyone)   
5)Enter runner executor (shell)  

**Install nginx**  
sudo apt-get install nginx  
You should have ip return nginx greeting page: http://13.48.85.75/

**Setup nginx sites-enabled**  
cd /etc/nginx/sites-available/    
sudo cp default twentyone    
cd ..    
sudo ln -s /etc/nginx/sites-available/twentyone /etc/nginx/sites-enabled/    
sudo rm default    
sudo service nginx restart    

**Setup nginx to proxy backend**  
go to /etc/nginx/sites-available  
sudo nano twentyone  
add following code (change port if necessary)  
         
         location /api/ {  
             proxy_pass   http://localhost:8080;  
         }  
sudo service nginx restart   

**Setup nginx to return frontend**  

cd /var/www/
sudo ln -s /home/gitlab-runner/front-deployment/ /var/www/front-deployment

go to /etc/nginx/sites-available  
sudo nano twentyone  
change root to point to /var/www/front-deployment  
root /var/www/front-deployment  

sudo service nginx restart  
http://193.40.155.144/ should display your front  

**Restart backend service after buil**  
gitlab-ci.yml should contain: sudo service heroes restart  
Allow gitlab-runner to use sudo when restarting heroes service  
sudo visudo (add to the end)  
gitlab-runner ALL = NOPASSWD: /usr/sbin/service heroes *  

**Url breaks frontend**  
Go to /etc/nginx/sites-available  
Edit heroes file, add a rule for nginx to forward to index.html if it doesn't have other files  

    location / {
        index  index.html index.htm;
        if (!-e $request_filename){
          rewrite ^(.*)$ /index.html break;
        }
    }


**Install postgresql and create a new database**  

import GPG key and add postresql12 repo   
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -   

add repo contents to the system
echo "deb http://apt.postgresql.org/pub/repos/apt/ `lsb_release -cs`-pgdg main" |sudo tee  /etc/apt/sources.list.d/pgdg.list   

install postgresql12    

sudo apt update   
sudo apt -y install postgresql-12 postgresql-client-12   

go to postgres superadmin   
sudo su - postgres   

password for something   
psql -c "alter user postgres with password 'StrongAdminPassword'"   

go into sql editor   
psql   
 
create a database   
CREATE DATABASE mytestdb;   
add a user with a encrypted password   
CREATE USER mytestuser WITH ENCRYPTED PASSWORD 'MyStrongPass';   
give user all privileges   
GRANT ALL PRIVILEGES ON DATABASE mytestdb to mytestuser;   

**backend: connect application to postgresql W10**  
go to gitlab runner    
sudo su gitlab-runner   

cd /home/gitlab-runner/api-deployment/   

touch custom.yaml   
sudo nano custom.yaml   
copy paste your postgres code there   

after that restart backend:   
sudo systemctl daemon-reload  
sudo service twentyone restart  
