# Weather Type in Each Country

```sql
select
	c.country_name,
	case
		when avg(w.weather_state) <= 15 then "Cold"
		when avg(w.weather_state) >= 25 then "Hot"
		else "Warm"
	end as 'weather_type'
from
	Countries c inner join Weather w
	on c.country_id = w.country_id and
    w.day between '2019-11-01' and '2019-11-30'
group by c.country_id
```
