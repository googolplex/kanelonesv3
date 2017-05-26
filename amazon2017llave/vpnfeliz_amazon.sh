#!/bin/bash
# chmod 400 librocomprasv3.pem
# ssh -i "librocomprasv3.pem" ec2-52-90-69-183.compute-1.amazonaws.com

ssh -i "librocomprasv3.pem" -XC -D 8084 ubuntu@ec2-52-207-31-88.compute-1.amazonaws.com
