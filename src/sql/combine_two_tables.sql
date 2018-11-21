/*Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId is the primary key column for this table.
Table: Address

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId is the primary key column for this table.
Output:
FirstName, LastName, City, State

如果Address中有该人的地址,则拼接地址信息,否则地址信息填null
left join中关于where和on条件的几个知识点：
    1.多表left join是会生成一张临时表，并返回给用户
    2.where条件是针对最后生成的这张临时表进行过滤，过滤掉不符合where条件的记录，是真正的不符合就过滤掉。
    3.on条件是对left join的右表进行条件过滤，但依然返回左表的所有行，右表中没有的补为NULL
    4.on条件中如果有对左表的限制条件，无论条件真假，依然返回左表的所有行,但是会影响右表的匹配值。也就是说on中左表的限制条件只影响右表的匹配内容，不影响返回行数。
结论：
    1.where条件中对左表限制，不能放到on后面
    2.where条件中对右表限制，放到on后面，会有数据行数差异，比原来行数要多
*/

select Person.FirstName, Person.LastName, Address.City, Address.State from Person left join Address on Person.PersonId = Address.PersonId;
