## Tipo de cambio de moneda - Spring Boot

###### Developer: Alcibar Vasquez

### Tipos de monedas disponibles

<table><tbody><tr><td>ID</td><td>Origin Currency</td><td>Destination Currency</td><td>Change Type</td></tr><tr><td>1</td><td>SOL</td><td>USD</td><td>3.85</td></tr><tr><td>2</td><td>SOL</td><td>EUR</td><td>4.05</td></tr><tr><td>3</td><td>USD</td><td>EUR</td><td>1.05</td></tr><tr><td>4</td><td>USD</td><td>SOL</td><td>0.26</td></tr><tr><td>5</td><td>EUR</td><td>SOL</td><td>0.25</td></tr><tr><td>6</td><td>EUR</td><td>USD</td><td>0.95</td></tr></tbody></table>

### Pruebas en Postman

#### Listar monedas disponibles

GET

```plaintext
http://localhost:8080/api/v1/currency
```

#### Calcular tipo de cambio

 POST

```plaintext
http://localhost:8080/api/v1/change-type
```

Request

```typescript
{
    "amount": 10,
    "originCurrency": "SOL",
    "destinationCurrency": "USD"
}
```

Response

```typescript
{
    "amount": 10.0,
    "changeAmount": 2.6,
    "originCurrency": "SOL",
    "destinationCurrency": "USD",
    "changeType": 3.85
}
```

Ejemplo

![](https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/59b736092804552692630f42e4fb3d6ee1d25c8982d47865.png)

#### Adicional - Actualizar tipo de cambio

PUT

```plaintext
http://localhost:8080/api/v1/currency/1
```

Request

```typescript
{
    "originCurrency": "SOL",
    "destinationCurrency": "USD",
    "changeType": 3.87
}
```

Response

```typescript
{
    "id": 1,
    "originCurrency": "SOL",
    "destinationCurrency": "USD",
    "changeType": 3.87
}
```

Ejemplo

![](https://33333.cdn.cke-cs.com/kSW7V9NHUXugvhoQeFaf/images/df2ed186928ea01e84aead08843db777493e891d32943da8.png)