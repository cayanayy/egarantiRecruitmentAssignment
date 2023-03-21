# egaranti Recruitment Assignment

##### by Çayan AY

## Getting Started

###### Assignment details: https://docs.google.com/document/d/1SEwSWQnQZ7ko06urBGhH1HFOIfm1QNEm/edit

For build up this project; you need docker, or you can make your own customization.
Database (PostgresSQL) already included in docker compose.

---

### If downloaded, cd to that directory and:

    mvn clean package
    docker compose up

---

#### Store Operations

<details>
 <summary><code>GET</code> <code><b>/store/all</b></code> <code>(get all stores)</code></summary>

##### Parameters

> None

</details>

<details>
 <summary><code>GET</code> <code><b>/store?id=</b></code> <code>(get store)</code></summary>

##### Query Params

| name | type     | data type | description |
|------|----------|-----------|-------------|
| id   | required | long, int | id of store |

#### Example Request

> localhost:8080/store?id=1


</details>

<details>
 <summary><code>POST</code> <code><b>/store</b></code> <code>(create store)</code></summary>

##### Request Body raw (json)

| name | type     | data type | description       |
|------|----------|-----------|-------------------|
| name | required | string    | name of the store |

#### Example Request

> {\
> "name": "kitapevi"\
> }

</details>

<details>
  <summary><code>DEL</code> <code><b>/store?id=</b></code> <code>(deletes store by id)</code></summary>

##### Query Params

| name | type     | data type | description |
|------|----------|-----------|-------------|
| id   | required | long, int | id of store |

#### Example Request

> localhost:8080/store?id=1

</details>

<details>
  <summary><code>PUT</code> <code><b>/store</b></code> <code>(updates store details)</code></summary>

##### Request Body raw (json)

| name | type     | data type | description           |
|------|----------|-----------|-----------------------|
| id   | required | long, int | id of store           |
| name | required | string    | new name of the store |

#### Example Request

> {\
> "id": 1,\
> "name": "yeni kitapevi"\
> }

</details>

<details>
  <summary><code>POST</code> <code><b>/store/add-employee</b></code> <code>(adds employee to specified store)</code></summary>

##### Request Body raw (json)

| name       | type     | data type | description        |
|------------|----------|-----------|--------------------|
| storeId    | required | long, int | id of store        |
| employeeId | required | long, int | id of the employee |

#### Example Request

> {\
> "storeId": 1,\
> "employeeId": 1\
> }

</details>

<details>
  <summary><code>POST</code> <code><b>/store/remove-employee</b></code> <code>(removes employee from specified store)</code></summary>

##### Request Body raw (json)

| name       | type     | data type | description        |
|------------|----------|-----------|--------------------|
| storeId    | required | long, int | id of store        |
| employeeId | required | long, int | id of the employee |

#### Example Request

> {\
> "storeId": 1,\
> "employeeId": 1\
> }

</details>

<details>
  <summary><code>POST</code> <code><b>/store/expense/per-month?storeId=</b></code> <code>(calculates expense of the store)</code></summary>

##### Query Params

| name    | type     | data type | description |
|---------|----------|-----------|-------------|
| storeId | required | long, int | id of store |

#### Example Request

> localhost:8080/store/expense/per-month?storeId=1

</details>

<details>
  <summary><code>POST</code> <code><b>/store/expense/per-employee?storeId=</b></code> <code>(calculates expense of the store per employee)</code></summary>

##### Query Params

| name    | type     | data type | description |
|---------|----------|-----------|-------------|
| storeId | required | long, int | id of store |

#### Example Request

> localhost:8080/store/expense/per-employee?storeId=1

</details>

<details>
  <summary><code>POST</code> <code><b>/store/expense</b></code> <code>(adds expense to store)</code></summary>

##### Request Body raw (json)

| name           | type     | data type | description        |
|----------------|----------|-----------|--------------------|
| storeId        | required | long, int | id of store        |
| expenseDetails | required | string    | details of expense |
| expenseValue   | required | string    | value of expense   |

#### Example Request

> {\
> "storeId": 1,\
> "expenseDetails": "Wall painting",\
> "expenseValue": 15555\
> }

</details>

------------------------------------------------------------------------------------------

#### Employee Operations

<details>
 <summary><code>GET</code> <code><b>/employee/all</b></code> <code>(get all employees)</code></summary>

##### Parameters

> None

</details>

<details>
 <summary><code>GET</code> <code><b>/employee?id=</b></code> <code>(get employee)</code></summary>

##### Query Params

| name | type     | data type | description    |
|------|----------|-----------|----------------|
| id   | required | long, int | id of employee |

#### Example Request

> localhost:8080//employee?id=1

</details>

<details>
 <summary><code>POST</code> <code><b>/employee</b></code> <code>(create employee)</code></summary>

##### Request Body raw (json)

! role must be ADMIN or USER otherwise will cause an error

| name      | type     | data type | description            |
|-----------|----------|-----------|------------------------|
| firstName | required | string    | first name of employee |
| lastName  | required | string    | last name of employee  |
| role      | required | string    | role of employee       |

#### Example Request

> {\
> "firstName": "Ahmet",\
> "lastName": "Yılmaz",\
> "role": "USER"\
> }

</details>

<details>
  <summary><code>DEL</code> <code><b>/employee?id=</b></code> <code>(deletes employee by id)</code></summary>

##### Query Params

| name | type     | data type | description    |
|------|----------|-----------|----------------|
| id   | required | long, int | id of employee |

#### Example Request

> localhost:8080//employee?id=1

</details>

<details>
  <summary><code>PUT</code> <code><b>/employee</b></code> <code>(updates employee details)</code></summary>

##### Request Body raw (json)

! role must be ADMIN or USER otherwise will cause an error

| name      | type     | data type | description                    |
|-----------|----------|-----------|--------------------------------|
| id        | required | long, int | id of store                    |
| firstName | optional | string    | new first name of the employee |
| lastName  | optional | string    | new last name of the employee  |
| role      | optional | string    | new role of the employee       |

#### Example Request

> {\
> "id": 1,\
> "firstName": "Kadir",\
> "role": "ADMIN"\
> }

</details>

------------------------------------------------------------------------------------------
