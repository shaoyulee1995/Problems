# Reformat Department Table

```sql
select
    id,
    sum(if(month = 'Jan', revenue, NULL)) as Jan_Revenue,
    sum(if(month = 'Feb', revenue, NULL)) as Feb_Revenue,
    sum(if(month = 'Mar', revenue, NULL)) as Mar_Revenue,
    sum(if(month = 'Apr', revenue, NULL)) as Apr_Revenue,
    sum(if(month = 'May', revenue, NULL)) as May_Revenue,
    sum(if(month = 'Jun', revenue, NULL)) as Jun_Revenue,
    sum(if(month = 'Jul', revenue, NULL)) as Jul_Revenue,
    sum(if(month = 'Aug', revenue, NULL)) as Aug_Revenue,
    sum(if(month = 'Sep', revenue, NULL)) as Sep_Revenue,
    sum(if(month = 'Oct', revenue, NULL)) as Oct_Revenue,
    sum(if(month = 'Nov', revenue, NULL)) as Nov_Revenue,
    sum(if(month = 'Dec', revenue, NULL)) as Dec_Revenue
from
    Department d
group by 1;

```
