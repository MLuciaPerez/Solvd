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
    doctor_id INT PRIMARY KEY AUTO_INCREMENT,
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