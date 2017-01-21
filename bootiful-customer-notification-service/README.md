## Cutomer notification service
Spring boot demo.

## Steps to run

	* Run rabbitmq server
	* Run fake SMTP server at 2525 port - https://nilhcem.github.io/FakeSMTP
	* Run customer-service and customer-notification-service as spring boot apps
	* Open HAL browser at http://localhost:8080 in browser
	* Click on non-get link and add a new customer at /register
	* A notification mail will be sent
