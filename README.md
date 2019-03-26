# Microservices de Pedidos - Fiap 2019



### Salvar um novo pedido:

**Endpoint:**/save

**Exemplo:**

```
{
	"id": <id>,
	"email": "<email>",
	"fullName": "<nome completo>",
	"shippingAddress": "<endereço>",
	"total": <valor total>,
	"date": <data do pedido>,
	"status": <status do pedido>,
	"items":[
				{
          				"id": <id do item>
					"description": "<descrição do item>",
					"price": <preco do item>,
					"quantity": <quantidade de itens>
				},
				{
					"id": <id do item>
					"description": "<descrição do item>",
					"price": <preco do item>,
					"quantity": <quantidade de itens>
				}
	],
	"payment": {
					id": <id>,
					"cardNumber": "<numero do cartao>",
					"expireDate": "<data de validade do cartao>",
					"operator": "<bandeira>",
					"totalValue": <valor total>
				}
}
```

---

### Atualizar um pedido:

**Endpoint:**/update

**Exemplo:**

```
{
	"id": <id>,
	"email": "<email>",
	"fullName": "<nome completo>",
	"shippingAddress": "<endereço>",
	"total": <valor total>,
	"date": <data do pedido>,
	"status": <status do pedido>,
	"items":[
				{
					"id": <id do item>
					"description": "<descrição do item>",
					"price": <preco do item>,
					"quantity": <quantidade de itens>
				},
				{
					"id": <id do item>
					"description": "<descrição do item>",
					"price": <preco do item>,
					"quantity": <quantidade de itens>
				}
	],
	"payment": {
					id": <id>,
					"cardNumber": "<numero do cartao>",
					"expireDate": "<data de validade do cartao>",
					"operator": "<bandeira>",
					"totalValue": <valor total>
				}
}
```

---

### Remover um pedido

**Endpoint:**/delete/{id do pedido}

**Exemplo:**

```
/delete/123
```

---

### Recuperar um pedido

**Endpoint:**/findById/{id do pedido}

**Exemplo:**

```
/findById/123
```
