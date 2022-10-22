# MySQL
```
update Salary
set sex = if(sex ="m", "f", "m");
```

# SQL
```
update Salary
set sex = (case
            when sex = 'f' then 'm'
            else 'f'
            end)
```