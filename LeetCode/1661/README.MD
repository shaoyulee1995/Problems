# Average Time of Process per Machine

```sql
select
    start.machine_id,
    round(avg(end.timestamp - start.timestamp), 3) as 'processing_time'
from
    Activity start join Activity end
    using(machine_id)
where
    start.activity_type = 'start' and
    end.activity_type = 'end'
group by
    1
```

```sql
select
    start.machine_id,
    round(avg(end.timestamp - start.timestamp), 3) as 'processing_time'
from
    Activity start join Activity end
    on start.machine_id = end.machine_id and
    start.activity_type = 'start' and
    end.activity_type = 'end'
group by
    1
```
