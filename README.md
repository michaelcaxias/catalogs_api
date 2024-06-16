## Catalogs API

### Description

This project is a simple API that allows you to manage categories and products.
It also has a consumer that listens to a SNS topic, creates a full catalog for a specific owner and save it in AWS S3.

#### Techs Used

![springboot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![aws](https://img.shields.io/badge/Amazon_AWS-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white)
![mongodb](https://img.shields.io/badge/MongoDB-47A248?style=for-the-badge&logo=mongodb&logoColor=white)
![docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)

- AWS Services
  - SNS/SQS
  - S3
  - DocumentDB

### Installation

1. Clone the repository

```bash
git clone git@github.com:michaelcaxias/catalogs_api.git
```

2. Install dependencies
3. Set up the environment variables

```bash
AWS_REGION=us-east-1
AWS_ACCESS_KEY_ID=your_access_key_id
AWS_SECRET_KEY=your_secret_key
AWS_SNS_CATALOG_EMITTER_ARN=arn:aws:sns:us-east-1:123456789012:catalogs

# For this project, the MongoDB is running in a docker container
MONGO_DB_HOST=localhost
MONGO_DB_PORT=27017
MONGO_DB_USERNAME=admin
MONGO_DB_PASSWORD=password

MONGO_DB_AUTH_DB=admin
```

### API Endpoints

You can download the Postman collection [here](./collections/catalogs-api.postman_collection.json)

```http
GET /catalogs-api/v1/categories
GET /catalogs-api/v1/products
GET /catalogs-api/v1/categories/{id}
GET /catalogs-api/v1/products/{id}
POST /catalogs-api/v1/categories
POST /catalogs-api/v1/products
PUT /catalogs-api/v1/categories/{id}
PUT /catalogs-api/v1/products/{id}

POST /catalogs-api/v1/consumer/catalogs/
```