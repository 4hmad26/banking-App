#  Banking App (Spring Boot)

A simple banking application built using Spring Boot.

##  Features
- Create Account
- Deposit & Withdraw
- Money Transfer (Transactional)
- Transaction History (Basic)

##  Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- REST API

## API Endpoints

### Create Account
POST /api/accounts

### Deposit
POST /api/accounts/{id}/deposit?amount=1000

### Withdraw
POST /api/accounts/{id}/withdraw?amount=500

### Transfer
POST /api/accounts/transfer

```json
{
  "fromId": 1,
  "toId": 2,
  "amount": 1000
}
