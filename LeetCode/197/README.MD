# Rising Temperature
```
select
    today.id as 'Id'
from
    Weather yesterday,
    Weather today
where 
    today.temperature > yesterday.temperature and
    DateDiff(today.recordDate, yesterday.recordDate) = 1
```