## E-Neptun is University Management System - developed to handle all necessary data-related processes throughout the university. The project achieves the goal by providing personal acccounts to both staffs and students separately. The project uses Java Swing to design GUI.

##                                                        Description 
At university, a large amount of data is processed and the results are used in running an organization. The University management system project maintains the list of departments and faculties. It also maintains students and staffs with a proper menu system.
University Management System will allow student to apply for any program available at the university through the system. If the student gets admission to the university, which is approved by registration clerk, he/she will have a student account through which the student can register subjects of the enrolled program and see personal information (name, surname, contact info, pre-instutition etc.), registered subjects, grade books and grade average. While for university staffs, there are 3 types of accounts: department head, faculty head, registration clerk and teacher:
- Teacher account – can register a new classroom and set students’ gradebooks
- Head accounts - have authority to register a subject for the department which he/she is head of
- Dean accounts - can register a program for the faculty which he/she is dean of 

###       Use-case Diagram
<img width="499" alt="image" src="https://user-images.githubusercontent.com/58053558/158981885-da613cf1-4d95-4235-afa9-536a4f18e244.png">

   As can be seen from the use-case diagram, a student can apply for a program, if accepted, he/she can do subject registration, view registered subjects, class schedule, gradebook, personal info and payment, drop subjects and make requests. On the other hand, a teacher can view classrooms in which schedule can be viewed and marks for students can be inserted. Beside that, a teacher can register classrooms and exam date for them and view the personal info. For the dean and head accounts, they can register and view programs and subjects, respectively. Lastly, a registration clerk can view applications and accept/deny them.

###       Achievements

- All data is loaded from corresponding files and stored through serialization and deserialization, so the data can be modified during any executions 
- Initial menu is represented in order to define whether the user is staff or student
- Appropriate menus is represented later according to account types
- 6-letter login name is generated automatically and represented to user at the end of successful registration.
- Unique IDs with certain length for all objects are generated as well upon to initializing new object
- Exception handling is implemented in order to avoid some incorrect inputs
- All the modified data is saved into the corresponding files at the end of executions

###     Sequence Diagrams
- Sequence Diagram for Main Frame
<img width="454" alt="image" src="https://user-images.githubusercontent.com/58053558/158983092-f887c1b6-7ce6-44e9-895c-982eb017a6f1.png">
- Sequence Diagram for  Student Login Frame
<img width="454" alt="image" src="https://user-images.githubusercontent.com/58053558/158983937-3a8b6eee-e145-4eee-8dc5-dba819edbe8e.png">

- Sequence Diagram for  Student Account
<img width="454" alt="image" src="https://user-images.githubusercontent.com/58053558/158983880-06e4a191-3986-4007-b5ac-7bd32d20800d.png">
<img width="454" alt="image" src="https://user-images.githubusercontent.com/58053558/158983908-d00b7d1f-768c-4c6c-85ed-15984cb18247.png">

- Sequence Diagram for  Staff Login Frame
- <img width="454" alt="image" src="https://user-images.githubusercontent.com/58053558/158983824-7ff124ff-aa4f-4704-84a1-a7a28deb82fa.png">

- Sequence Diagram for  Staff Account
<img width="454" alt="image" src="https://user-images.githubusercontent.com/58053558/158983769-51c05d20-1ae3-4734-817d-8329997dd2c6.png">

- Sequence Diagram for  Dean Account
<img width="454" alt="image" src="https://user-images.githubusercontent.com/58053558/158983718-ecaa6d40-468f-432e-ae6a-12ee10a842f9.png">
<img width="454" alt="image" src="https://user-images.githubusercontent.com/58053558/158983736-73e4f3a8-71dd-493e-bf39-1b2315a11871.png">

- Sequence Diagram for  Teacher Account
<img width="454" alt="image" src="https://user-images.githubusercontent.com/58053558/158983653-ec1f56bf-a133-4522-b6af-85f5788bc789.png">
<img width="454" alt="image" src="https://user-images.githubusercontent.com/58053558/158983674-19dd8a6e-303a-4d81-912b-10555bc5250c.png">

- Sequence Diagram for  Technical Staff Account
<img width="454" alt="image" src="https://user-images.githubusercontent.com/58053558/158983577-3b3a1a39-ab73-49ab-8a67-a0494d5e19ca.png">
<img width="454" alt="image" src="https://user-images.githubusercontent.com/58053558/158983614-7392caa1-d137-4685-80de-801ed95a96c8.png">



