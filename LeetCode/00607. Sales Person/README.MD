# SQL
```
select s.name
from salesperson s
where s.name not in (select s.name
                     from orders o
                     inner join company c on c.com_id = o.com_id
                     left join salesperson s on s.sales_id = o.sales_id 
                     where c.name = 'RED')
order by s.name asc
```