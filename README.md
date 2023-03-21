# egaranti Recruitment Assignment

##### by Çayan AY

## Getting Started

###### Assignment details: https://docs.google.com/document/d/1SEwSWQnQZ7ko06urBGhH1HFOIfm1QNEm/edit

For build up this project; you need docker, or you can make your own customization.
Database (PostgresSQL) already included in docker compose.

---

### If downloaded, cd to that directory and:

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

</details>

<details>
 <summary><code>POST</code> <code><b>/store</b></code> <code>(create store)</code></summary>

##### Request Body

| name | type     | data type | description       |
|------|----------|-----------|-------------------|
| name | required | string    | name of the store |

</details>

<details>
  <summary><code>DEL</code> <code><b>/store?id=</b></code> <code>(deletes store by id)</code></summary>

##### Query Params

| name | type     | data type | description |
|------|----------|-----------|-------------|
| id   | required | long, int | id of store |

</details>

<details>
  <summary><code>PUT</code> <code><b>/store</b></code> <code>(updates store details)</code></summary>

##### Request Body

| name | type     | data type | description           |
|------|----------|-----------|-----------------------|
| id   | required | long, int | id of store           |
| name | required | string    | new name of the store |

</details>

<details>
  <summary><code>POST</code> <code><b>/store/add-employee</b></code> <code>(adds employee to specified store)</code></summary>

##### Request Body

| name       | type     | data type | description        |
|------------|----------|-----------|--------------------|
| storeId    | required | long, int | id of store        |
| employeeId | required | long, int | id of the employee |

</details>

<details>
  <summary><code>POST</code> <code><b>/store/remove-employee</b></code> <code>(removes employee from specified store)</code></summary>

##### Request Body

| name       | type     | data type | description        |
|------------|----------|-----------|--------------------|
| storeId    | required | long, int | id of store        |
| employeeId | required | long, int | id of the employee |

</details>

<details>
  <summary><code>POST</code> <code><b>/store/expense/per-month?storeId=</b></code> <code>(calculates expense of the store)</code></summary>

##### Query Params

| name    | type     | data type | description |
|---------|----------|-----------|-------------|
| storeId | required | long, int | id of store |

</details>

<details>
  <summary><code>POST</code> <code><b>/store/expense/per-employee?storeId=</b></code> <code>(calculates expense of the store per employee)</code></summary>

##### Query Params

| name    | type     | data type | description |
|---------|----------|-----------|-------------|
| storeId | required | long, int | id of store |

</details>

<details>
  <summary><code>POST</code> <code><b>/store/expense</b></code> <code>(adds expense to store)</code></summary>

##### Query Params

| name           | type     | data type | description        |
|----------------|----------|-----------|--------------------|
| storeId        | required | long, int | id of store        |
| expenseDetails | required | string    | details of expense |
| expenseValue   | required | string    | value of expense   |

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

</details>

<details>
 <summary><code>POST</code> <code><b>/employee</b></code> <code>(create employee)</code></summary>

##### Request Body

<span style="color:red">
role must be ADMIN or USER otherwise will cause an error.
</span>

| name      | type     | data type | description            |
|-----------|----------|-----------|------------------------|
| firstName | required | string    | first name of employee |
| lastName  | required | string    | last name of employee  |
| role      | required | string    | role of employee       |

</details>

<details>
  <summary><code>DEL</code> <code><b>/employee?id=</b></code> <code>(deletes employee by id)</code></summary>

##### Query Params

| name | type     | data type | description    |
|------|----------|-----------|----------------|
| id   | required | long, int | id of employee |

</details>

<details>
  <summary><code>PUT</code> <code><b>/employee</b></code> <code>(updates employee details)</code></summary>

##### Request Body

<span style="color:red">
role must be ADMIN or USER otherwise will cause an error.
</span>

| name      | type     | data type | description                    |
|-----------|----------|-----------|--------------------------------|
| id        | required | long, int | id of store                    |
| firstName | optional | string    | new first name of the employee |
| lastName  | optional | string    | new last name of the employee  |
| role      | optional | string    | new role of the employee       |

</details>

------------------------------------------------------------------------------------------
