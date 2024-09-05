# noj-cloud

## 技术选型

| Spring Cloud Alibaba Version | 	Spring Cloud Version | 	Spring Boot Version |
|------------------------------|-----------------------|----------------------|
| 2023.0.1.0*                  | Spring Cloud 2023.0.1 | 3.2.4                |

| Spring Cloud Alibaba Version | 	Sentinel Version | 	Nacos Version | 	RocketMQ Version | 	Seata Version |
|------------------------------|-------------------|----------------|-------------------|----------------|
| 2023.0.1.0                   | 	1.8.6            | 	2.3.2	        | 5.1.4             | 	2.0.0         |

## 端口编排

### manage

| service          | port |
|------------------|------|
| manage-gateway   | 5000 |
| code-sandbox     | 5010 |
| manage-question  | 5030 |
| manage-user      | 5041 |
| manage-community | 5050 |

### miniprogram

| service      | port |
|--------------|------|
| mini-gateway | 7000 |
| copilot      | 7010 |
| mini-user    | 7020 |
