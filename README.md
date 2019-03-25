# Microservice Order Web Service

## Getting Started

## Endpoints
#### Create Order
###### POST http://localhost:8080/save
```javascript
{
    "email": "julianomarquesnunes@gmail.com",
    "nomeCompleto": "Juliano Marques Nune",
    "shippingAddress": "Rua do Google, Silicon Valey",
    "items": [
    	{
    		"descricaoItem": "teste",
    		"quantidadeItem": 1,
    		"precoItem": 20.50
    	}	
    ],
    "formaPagto": {
    	"id": 14562,
    	"numeroCartao": "5555 5555 5555 5555",
    	"validar": "01/20",
    	"bandeira": "mastercard"
    }
}
```

#### Get Order
###### GET http://localhost:8080/findById/{id}

#### Delete Order
###### DELETE http://localhost:8080/order/{id}

#### Update Order

```javascript
{
    "id": 1,
    "email": "exemplodealteracao@gmail.com",
    "nomeCompleto": "Juliano Marques Nune",
    "shippingAddress": "Rua do Google, Silicon Valey",
    "items": [
    	{
    		"descricaoItem": "teste",
    		"quantidadeItem": 1,
    		"precoItem": 20.50
    	},
      {
    		"descricaoItem": "teste1",
    		"quantidadeItem": 1,
    		"precoItem": 356.42
    	}	
    ],
    "formaPagto": {
    	"id": 14562,
    	"numeroCartao": "5555 5555 5555 5555",
    	"validar": "01/20",
    	"bandeira": "mastercard"
    }
}
```
