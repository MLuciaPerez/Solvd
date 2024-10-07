CREATE DATABASE ClinicDB;
USE ClinicDB;

-- 1. Department 
CREATE TABLE Department (
    department_id INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(100) NOT NULL
);

-- 2. Room 
CREATE TABLE Room (
    room_id INT PRIMARY KEY AUTO_INCREMENT,
    room_number VARCHAR(10) NOT NULL,
    room_type VARCHAR(50),
    availability BOOLEAN NOT NULL
);

-- 3. Doctor 
CREATE TABLE Doctor (
    doctor_id INT PRIMARY KEY AUTO_INCREMENT ,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    specialization VARCHAR(50),
    phone VARCHAR(20),
    email VARCHAR(100),
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES Department(department_id)
);


-- 4. Patient
CREATE TABLE Patient (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100),
    address VARCHAR(200)
);

-- 5. Nurse 
CREATE TABLE Nurse (
    nurse_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    shift VARCHAR(20),
    phone VARCHAR(20),
    email VARCHAR(100),
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES Department(department_id)
);

-- 6. MedicalEquipment 
CREATE TABLE MedicalEquipment (
    equipment_id INT PRIMARY KEY AUTO_INCREMENT,
    equipment_name VARCHAR(100) NOT NULL,
    equipment_type VARCHAR(50),
    nurse_id INT,
    FOREIGN KEY (nurse_id) REFERENCES Nurse(nurse_id)
);

-- 7. Receptionist
CREATE TABLE Receptionist (
    receptionist_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(100)
);

-- 8. Appointment 
CREATE TABLE Appointment (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    doctor_id INT,
    patient_id INT,
    room_id INT,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (room_id) REFERENCES Room(room_id)
);

-- 9. Medication
CREATE TABLE Medication (
    medication_id INT PRIMARY KEY AUTO_INCREMENT,
    medication_name VARCHAR(100) NOT NULL,
    dosage VARCHAR(50),
    price DECIMAL(10, 2)
);

-- 10. Prescription 
CREATE TABLE Prescription (
    prescription_id INT PRIMARY KEY AUTO_INCREMENT,
    prescription_date DATE NOT NULL,
    patient_id INT,
    doctor_id INT,
    medication_id INT,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id),
    FOREIGN KEY (medication_id) REFERENCES Medication(medication_id)
);

-- 11. Billing 
CREATE TABLE Billing (
    billing_id INT PRIMARY KEY AUTO_INCREMENT,
    billing_date DATE NOT NULL,
    patient_id INT,
    amount DECIMAL(10, 2) NOT NULL,
    payment_status VARCHAR(20) NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
);

-- 12. Treatment 
CREATE TABLE Treatment (
    treatment_id INT PRIMARY KEY AUTO_INCREMENT,
    treatment_name VARCHAR(100) NOT NULL,
    treatment_description TEXT,
    patient_id INT,
    doctor_id INT,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);


-- Insert departments
INSERT INTO Department (department_name) VALUES ('Cardiology');
INSERT INTO Department (department_name) VALUES ('Neurology');

-- Insert rooms
INSERT INTO Room (room_number, room_type, availability) VALUES ('101', 'Private', TRUE);
INSERT INTO Room (room_number, room_type, availability) VALUES ('102', 'ICU', TRUE);

-- Insert doctors
INSERT INTO Doctor (first_name, last_name, specialization, phone, email, department_id) 
VALUES ('John', 'Doe', 'Cardiologist', '123456789', 'johndoe@clinic.com', 1);

INSERT INTO Doctor (first_name, last_name, specialization, phone, email, department_id) 
VALUES ('Alice', 'Smith', 'Neurologist', '987654321', 'alicesmith@clinic.com', 2);

-- Insert patients
INSERT INTO Patient (first_name, last_name, birth_date, phone, email, address) 
VALUES ('Mary', 'Johnson', '1985-07-15', '456789123', 'maryj@clinic.com', '123 Main St');

INSERT INTO Patient (first_name, last_name, birth_date, phone, email, address) 
VALUES ('Robert', 'Brown', '1990-03-22', '654321987', 'robertb@clinic.com', '456 Oak St');

-- Insert nurses
INSERT INTO Nurse (first_name, last_name, shift, phone, email, department_id) 
VALUES ('Laura', 'Wilson', 'Morning', '321654987', 'lauraw@clinic.com', 1);

INSERT INTO Nurse (first_name, last_name, shift, phone, email, department_id) 
VALUES ('Emma', 'Davis', 'Night', '741258963', 'emmad@clinic.com', 2);

-- Insert medications
INSERT INTO Medication (medication_name, dosage, price) VALUES ('Aspirin', '100mg', 5.00);
INSERT INTO Medication (medication_name, dosage, price) VALUES ('Ibuprofen', '200mg', 10.00);


-- 10 Statements for Updating

-- Update department name
UPDATE Department SET department_name = 'Cardiology Department' WHERE department_id = 1;

-- Update room availability
UPDATE Room SET availability = FALSE WHERE room_id = 1;

-- Update doctor's phone number
UPDATE Doctor SET phone = '555555555' WHERE doctor_id = 1;

-- Update patient's email
UPDATE Patient SET email = 'maryjohnson@clinic.com' WHERE patient_id = 1;

-- Update nurse's shift
UPDATE Nurse SET shift = 'Afternoon' WHERE nurse_id = 1;

-- Update medication price
UPDATE Medication SET price = 12.00 WHERE medication_id = 2;

-- Update appointment date and time
UPDATE Appointment SET appointment_date = '2024-10-10', appointment_time = '10:00:00' WHERE appointment_id = 1;

-- Update prescription date
UPDATE Prescription SET prescription_date = '2024-10-05' WHERE prescription_id = 1;

-- Update billing amount
UPDATE Billing SET amount = 150.00 WHERE billing_id = 1;

-- Update treatment description
UPDATE Treatment SET treatment_description = 'Detailed description of treatment.' WHERE treatment_id = 1;


-- 10 Statements for Deletions

ALTER TABLE Doctor
DROP FOREIGN KEY doctor_ibfk_1,
ADD CONSTRAINT doctor_fk_department FOREIGN KEY (department_id) 
REFERENCES Department(department_id) ON DELETE CASCADE;
-- Drop the existing foreign key constraint on the Nurse table
ALTER TABLE Nurse
DROP FOREIGN KEY nurse_ibfk_1;
-- Add the foreign key constraint with ON DELETE CASCADE
ALTER TABLE Nurse
ADD CONSTRAINT nurse_fk_department FOREIGN KEY (department_id) 
REFERENCES Department(department_id) ON DELETE CASCADE;

-- Delete a department
DELETE FROM Department WHERE department_id = 2;

-- Delete a room
DELETE FROM Room WHERE room_id = 2;

-- Delete a doctor
DELETE FROM Doctor WHERE doctor_id = 2;

-- Delete a patient
DELETE FROM Patient WHERE patient_id = 2;

-- Delete a nurse
DELETE FROM Nurse WHERE nurse_id = 2;

-- Delete a medication
DELETE FROM Medication WHERE medication_id = 1;

-- Delete an appointment
DELETE FROM Appointment WHERE appointment_id = 1;

-- Delete a prescription
DELETE FROM Prescription WHERE prescription_id = 1;

-- Delete a billing record
DELETE FROM Billing WHERE billing_id = 1;

-- Delete a treatment
DELETE FROM Treatment WHERE treatment_id = 1;


-- 5 Alter Table Statements

-- Add a new column to Doctor table
ALTER TABLE Doctor ADD COLUMN gender VARCHAR(10);

-- Add a unique constraint to Patient email
ALTER TABLE Patient ADD CONSTRAINT unique_email UNIQUE (email);

-- Add a foreign key constraint to Billing (referencing Appointment table)
ALTER TABLE Billing ADD COLUMN appointment_id INT;
ALTER TABLE Billing ADD CONSTRAINT fk_billing_appointment FOREIGN KEY (appointment_id) REFERENCES Appointment(appointment_id);

-- Modify column type of Room number
ALTER TABLE Room MODIFY COLUMN room_number VARCHAR(20);


-- Drop foreign key from Prescription table
ALTER TABLE Prescription DROP FOREIGN KEY prescription_ibfk_2;


-- One Big Statement to Join All Tables
SELECT 
    p.first_name AS Patient, p.last_name AS Patient_LastName, 
    d.first_name AS Doctor, d.last_name AS Doctor_LastName, 
    r.room_number, r.room_type, 
    a.appointment_date, a.appointment_time, 
    n.first_name AS Nurse, n.last_name AS Nurse_LastName,
    m.medication_name, m.dosage, 
    t.treatment_name, t.treatment_description
FROM Patient p
JOIN Appointment a ON p.patient_id = a.patient_id
JOIN Doctor d ON a.doctor_id = d.doctor_id
JOIN Room r ON a.room_id = r.room_id
JOIN Treatment t ON p.patient_id = t.patient_id
JOIN Nurse n ON d.department_id = n.department_id
JOIN Prescription pr ON p.patient_id = pr.patient_id
JOIN Medication m ON pr.medication_id = m.medication_id;


-- 5 Join Statements with Left, Right, Inner, Outer Joins

-- Inner join between Patient and Appointment
SELECT p.first_name, p.last_name, a.appointment_date 
FROM Patient p 
INNER JOIN Appointment a ON p.patient_id = a.patient_id;

-- Left join between Doctor and Appointment
SELECT d.first_name, d.last_name, a.appointment_date 
FROM Doctor d 
LEFT JOIN Appointment a ON d.doctor_id = a.doctor_id;

-- Right join between Room and Appointment
SELECT r.room_number, a.appointment_date 
FROM Room r 
RIGHT JOIN Appointment a ON r.room_id = a.room_id;

-- Simulate FULL OUTER JOIN with LEFT JOIN and RIGHT JOIN combined with UNION
SELECT p.first_name, p.last_name, b.amount
FROM Patient p 
LEFT JOIN Billing b ON p.patient_id = b.patient_id
UNION
SELECT p.first_name, p.last_name, b.amount
FROM Patient p 
RIGHT JOIN Billing b ON p.patient_id = b.patient_id;

-- Left join between Nurse and MedicalEquipment
SELECT n.first_name, n.last_name, me.equipment_name 
FROM Nurse n 
LEFT JOIN MedicalEquipment me ON n.nurse_id = me.nurse_id;


-- 7 Statements with Aggregate Functions and GROUP BY Without HAVING
-- Count appointments per doctor
SELECT d.first_name, d.last_name, COUNT(a.appointment_id) AS appointment_count 
FROM Doctor d 
JOIN Appointment a ON d.doctor_id = a.doctor_id 
GROUP BY d.doctor_id;

-- Total billing per patient
SELECT p.first_name, p.last_name, SUM(b.amount) AS total_billed 
FROM Patient p 
JOIN Billing b ON p.patient_id = b.patient_id 
GROUP BY p.patient_id;

-- Average medication price
SELECT medication_name, AVG(price) AS avg_price 
FROM Medication 
GROUP BY medication_name;

-- Count patients per department
SELECT d.department_name, COUNT(p.patient_id) AS patient_count 
FROM Department d 
JOIN Doctor doc ON d.department_id = doc.department_id
JOIN Appointment a ON doc.doctor_id = a.doctor_id
JOIN Patient p ON a.patient_id = p.patient_id
GROUP BY d.department_name;

-- Total treatments per patient
SELECT p.first_name, p.last_name, COUNT(t.treatment_id) AS treatment_count 
FROM Patient p 
JOIN Treatment t ON p.patient_id = t.patient_id 
GROUP BY p.patient_id;

-- Count rooms by availability
SELECT availability, COUNT(room_id) AS room_count 
FROM Room 
GROUP BY availability;

-- Sum total billing amounts per status
SELECT payment_status, SUM(amount) AS total_amount 
FROM Billing 
GROUP BY payment_status;


-- -- Total billing per patient, only showing those with more than 200 billed
SELECT p.first_name, p.last_name, SUM(b.amount) AS total_billed 
FROM Patient p 
JOIN Billing b ON p.patient_id = b.patient_id 
GROUP BY p.patient_id 
HAVING SUM(b.amount) > 200;

-- Count appointments per doctor, showing only doctors with more than 3 appointments
SELECT d.first_name, d.last_name, COUNT(a.appointment_id) AS appointment_count 
FROM Doctor d 
JOIN Appointment a ON d.doctor_id = a.doctor_id 
GROUP BY d.doctor_id 
HAVING COUNT(a.appointment_id) > 3;

-- Average medication price, only showing medications priced above 8
SELECT medication_name, AVG(price) AS avg_price 
FROM Medication 
GROUP BY medication_name 
HAVING AVG(price) > 8;

-- Count patients per department, showing departments with more than 2 patients
SELECT d.department_name, COUNT(p.patient_id) AS patient_count 
FROM Department d 
JOIN Doctor doc ON d.department_id = doc.department_id
JOIN Appointment a ON doc.doctor
