# SQL
```
select user_id,
    concat(upper(left(name, 1)), lower(substring(name, 2, len(name)))) as 'name'
from Users
order by user_id
```