# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for? 
<br>Comma-Separated Values


2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?
<br>For scalability. If we want to expand users in the future, maybe other kind of lists will better suit the use case.
Thus, it is smart to keep the options. 


3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?
<br> has-a


4. Can you provide an example of a has-a relationship in your code (if one exists)?
<br> Employee class create PayStub objects and store them in field.


5. Can you provide an example of an is-a relationship in your code (if one exists)?
<br> SalaryEmployee and HourlyEmployee class extends abstract class Employee.


6. What is the difference between an interface and an abstract class?
<br> Interface only provides signatures and doesn't provide fields. On the other hand, abstract class provided detail 
of how methods are implemented.


7. What is the advantage of using an interface over an abstract class?
<br> An interface can be used as a blueprint of objects that share similar features. The advantage of is that it doesn't
require implementation details. Thus, the subclass of an interface can implement different methods based on their 
needs.


8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 
<br> It's not valid since ArrayList store memory location of an object. It doesn't accept primitive type.


9. Which class/method is described as the "driver" for your application? 
<br> PayRollGenerator.


10. How do you create a temporary folder for JUnit Testing? 
<br> I use JUnit 5's @TempDir Annotation. The temporary file and directory will be automatically clean up after testing
which makes it a good practice.


## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 

<br> I would add gender identity, race, ethnicity fields to the employee class. Also, I would add the position and 
level of position field. By doing this, it is possible to check how these attributes interact with each other. It 
makes it possible to see if there is salary inequality between different gender identity, race, and ethnicity.

Reference:
* https://www.statista.com/topics/3453/wage-inequality-in-the-united-states/#topicOverview
* https://ourworldindata.org/economic-inequality-by-gender