
Homework - Interface, static , final:
 
Polymorphism with Abstract Class and Interface
Doctor and Nurse are concrete classes that extend MedicalStaff. Both override the abstract method performDuties. Doctor implements Diagnosable, MedicationProvider, and Treatable, providing specific implementations for the methods. Patient implements Payable. Administrator implements Manag
eable.

Final Class, Method, and Variable
The Patient class is marked as final.
The method printPatientInfo() in the Patient class is marked as final.
The variable role in the Doctor class is marked as final.

Static Block, Method, and Variable
In HospitalUtils:
Static Block: initializes static variables and performing any other setup required when the class is first loaded.
Static variables: totalPatients and departmentPatientCount.
Static Methods: registerPatient(String department), showTotalPatients(), showPatientCountByDepartment().


Homework - Exceptions:

Custom Exceptions:
DepartmentNotFoundException: Thrown when the department does not exist.
InvalidAgeException: Thrown when a negative age is provided.
DuplicatePatientException: Thrown when a duplicate patient is registered.
InsufficientFundsException: Thrown when there are insufficient funds for payment.
UnauthorizedAccessException: Thrown when there is an attempt to access patient data without permission.

HospitalUtils Class:
Method registerPatient(String department, String patientName, int age): Registers a patient, handles exceptions like DepartmentNotFoundException, InvalidAgeException, and DuplicatePatientException.
The try-with-resources block is located in the registerPatient method. This block automatically handles the closing of the BufferedWriter after writing patient information to the patients.txt file.
Method processPayment(double amount): Processes payments and handles InsufficientFundsException.
Method accessPatientData(boolean hasPermission): Accesses patient data and handles UnauthorizedAccessException.

At the end of Main Class:
Exception Handling: Demonstrates handling of custom exceptions with try-catch blocks.



Homework - Collections:

ArrayList in the Patient class: Stores a list of medications.
HashSet in the Nurse class: Tracks the unique medical equipment a nurse handles.
HashMap in the Administrator class: Maps department names to the number of staff members in each department.
TreeSet in the Patient class: Stores a sorted set of appointment dates for each patient.
LinkedList in the Receptionist class: To manage patients.

Class CustomLinkedList.



Homework - Maven:

pom.xml: Includes configurations for the compiler, dependencies, and plugins.
Dependencies: Added dependencies for log4j-api and log4j-core.
Plugins: Added plugins for creating JAR files (maven-jar-plugin) and compiling the code (maven-compiler-plugin).




Homework - FileUtils and StringUtils:

Dependencies commons-io and commons-lang3 were added to use FileUtils and StringUtils.
Counter class is responsible for reading the file, counting the unique words and writing the result to an output file.





Homework -  lambda functions, Lambda functions with generics and complex Enums:

Integrated 5 lambda functions from the java.util.function package at the end of the Main class.

Added functional generic interfaces:
Comparator: Interface for comparing two Person objects (or its subclasses) based on a custom criterion.
Evaluator: Interface for evaluating a condition on a Person object and returning a result of type R.
Transformer: Interface for transforming a Person object into another type R.

Implemented (Also at end of the Main class) lambda expressions for:
Comparing patients by age using PatientComparator.
Evaluating if a patient is an adult using Evaluator.
Getting a patient's details as a string using Transformer.

Developed 5 Enums, each with fields, methods, and additional functionality to enhance class attributes.
Integarted the Enums in classes Doctor, Nurse, Administrator, Patient and Receptionist.




Homework - collection streaming/  reflection:

Added Stream Operations to Clinic Class:
Filtering Doctors: Added getExperiencedDoctors() to filter doctors with more than 5 patients.
Sorting Patients: Implemented getSortedPatients() to sort patients by their earliest appointment date.
Counting Nurses: Introduced countNurses() to count the total number of nurses.
Mapping Department Names: Added getDepartmentNamesInUppercase() to convert department names to uppercase.
Checking Busy Doctors: Added hasBusyDoctors() to check if any doctor has more than 10 patients.
Calculating Total Appointment Duration: Implemented getTotalAppointmentDuration() to sum up the duration of all appointments.
Getting First Patient: Added getFirstPatient() to retrieve the first patient in the queue, if available.

Updated main Method for Testing:
Tested New Methods: Added logging to test and verify the functionality of new stream-based methods in the Clinic class.
Reflection Testing: Added code to use reflection to extract and log details about fields, constructors, and methods of the Appointment class. Included reflection-based instantiation and method invocation examples.
