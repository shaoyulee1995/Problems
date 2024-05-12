# Swap Salary
```
update Salary
set sex = if(sex ="m", "f", "m");
```
```
update Salary
set sex = (case
            when sex = 'm'
            then 'f'
            else 'm'
          end)
```