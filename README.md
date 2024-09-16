
Homework lambda functions, Lambda functions with generics and complex Enums:

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



Homework  collection streaming/  reflection:

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
