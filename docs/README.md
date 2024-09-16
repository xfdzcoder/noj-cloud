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
| manage-question  | 5020 |
| manage-user      | 5030 |
| manage-community | 5041 |

### miniprogram

| service        | port |
|----------------|------|
| mini-gateway   | 7000 |
| mini-user      | 7010 |
| mini-community | 7020 |
| mini-question  | 7030 |

### universal

| service                       | port  |
|-------------------------------|-------|
| universal-code-sandbox-docker | 10000 |
| universal-copilot-spark       | 10010 |