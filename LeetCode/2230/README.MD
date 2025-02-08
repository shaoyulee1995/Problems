# The Users That Are Eligible for Discount

```sql
CREATE PROCEDURE getUserIDs(startDate DATE, endDate DATE, minAmount INT)
BEGIN
	  select
        distinct user_id
    from
        Purchases
    where
        Date(time_stamp) between startDate and Date_Sub(endDate, Interval 1 Day) and
        amount >= minAmount
    order by
        1;
END
```
