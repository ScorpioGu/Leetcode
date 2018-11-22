/**
 * @Desc https://leetcode.com/problems/second-highest-salary/description/
 * Write a SQL query to get the second highest salary from the Employee table.
 *
 * +----+--------+
 * | Id | Salary |
 * +----+--------+
 * | 1  | 100    |
 * | 2  | 200    |
 * | 3  | 300    |
 * +----+--------+
 * For example, given the above Employee table, the query should return 200 as the second highest salary. If there is no second highest salary, then the query should return null.
 *
 * +---------------------+
 * | SecondHighestSalary |
 * +---------------------+
 * | 200                 |

    当出现两个相同的数时,当成一个,比如给了两个100,那么second应该返回null
 **/


select max(Salary) as SecondHighestSalary from Employee where Salary < (select max(Salary) from Employee);


select (
  select distinct Salary from Employee order by Salary Desc limit 1 offset 1
)as SecondHighestSalary

-- 注意到这种写法是不对的,因为题目要求没有second时,返回null,下面这条语句,当没有second,是一个空表
select distinct Salary as SecondHighestSalary from Employee order by Salary Desc limit 1 offset 1

