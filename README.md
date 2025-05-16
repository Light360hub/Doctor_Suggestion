[DocSuggest.postman_collection.json](https://github.com/user-attachments/files/20257560/DocSuggest.postman_collection.json)
# DoctorSuggestion API

This project is a **Java-based technical assessment** completed for **Xcelore**. The objective is to develop backend APIs using **Spring Boot** and **Hibernate** for managing doctors and patients and providing doctor suggestions based on patient symptoms.

---

## 📌 Project Overview

This REST API enables the following functionalities:

- Adding and removing **doctors** with their specialities
- Adding and removing **patients** with their symptoms
- Suggesting doctors based on a **patient’s symptom and city**

---

## ⚙️ Technologies Used

- Java 17+
- Spring Boot 3.x
- Hibernate / JPA
- Maven
- Swagger (Springdoc OpenAPI)
- Postman (for testing)

---

## 📁 API Endpoints

### 👨‍⚕️ Doctor APIs

- `POST /api/doctors` – Add a doctor  
- `DELETE /api/doctors/{id}` – Delete a doctor  

Doctor Fields:
- Name (min 3 characters)
- City: Only `Delhi`, `Noida`, or `Faridabad`
- Email (valid format)
- Phone number (min 10 digits)
- Speciality: Only one of `Orthopaedic`, `Gynecology`, `Dermatology`, `ENT`

---

### 🧑‍⚕️ Patient APIs

- `POST /api/patients` – Add a patient  
- `DELETE /api/patients/{id}` – Delete a patient  

Patient Fields:
- Name (min 3 characters)
- City (max 20 characters)
- Email (valid format)
- Phone number (min 10 digits)
- Symptom:  
  - `Arthritis`, `Back Pain`, `Tissue injuries` → Orthopaedic  
  - `Dysmenorrhea` → Gynecology  
  - `Skin infection`, `Skin burn` → Dermatology  
  - `Ear pain` → ENT

---

### 🤖 Doctor Suggestion API

- `GET /api/suggestions/{patientId}` – Suggest doctors based on the patient’s symptom and city

#### Logic:
- Matches the patient’s symptom to a speciality
- Finds doctors of that speciality in the same city

#### Edge Cases:
- If the city is not Delhi, Noida, or Faridabad:  
  ➤ `"We are still waiting to expand to your location"`
- If no doctor matches the symptom in that city:  
  ➤ `"There isn’t any doctor present at your location for your symptom"`

---

## 🧪 Postman Collection

A Postman collection for testing the APIs is included:
- Add Doctor
- Add Patient
- Suggest Doctor (with sample IDs)
- Handles edge cases

📂 File: 
({
	"info": {
		"_postman_id": "8d6e7e8d-f840-4f58-b26d-62219c6f6ece",
		"name": "DocSuggest",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "42761692"
	},
	"item": [
		{
			"name": "Patient",
			"item": [
				{
					"name": "Add Patient",
					"request": {
						"method": "POST",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/patients",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"patients"
							]
						}
					},
					"response": []
				},
				{
					"name": "Delete Patient",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/patients/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"patients",
								"1"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "Doctor",
			"item": [
				{
					"name": "Add Doctors",
					"request": {
						"method": "POST",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/doctors",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"doctors"
							]
						}
					},
					"response": []
				},
				{
					"name": "Delete Doctor",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/doctors/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"doctors",
								"1"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "New Request",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "http://localhost:8080/patients/suggest-doctor/1",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"patients",
						"suggest-doctor",
						"1"
					]
				}
			},
			"response": []
		}
	]
})

---

## 📸 Screenshots
Add Doctor ![Screenshot 2025-05-16 225752](https://github.com/user-attachments/assets/3474f3ab-5266-4bbb-a2bb-0795bdd693b8)
Delete Doctor ![Screenshot 2025-05-16 225909](https://github.com/user-attachments/assets/576ad41c-45e3-40ae-9782-2bfae940a012)
Add Patient ![Screenshot 2025-05-16 230006](https://github.com/user-attachments/assets/070cead4-5ac1-487d-a1d4-f8bc85711f7c)
Delete Patient ![Screenshot 2025-05-16 230057](https://github.com/user-attachments/assets/c9bad9d4-f0b9-40c0-8148-e24263405341)
Edge Case 1 ![Screenshot 2025-05-16 230243](https://github.com/user-attachments/assets/7a774c7d-2bf2-4f2f-86c6-6f55f1b94d04)
Edge Case 2 ![Screenshot 2025-05-16 230620](https://github.com/user-attachments/assets/8046adb0-9611-4523-90fb-f7c1322acd6b)

## ✅ Getting Started

### Clone and Run
```bash
git clone https://github.com/yourusername/DoctorSuggestion.git
cd DoctorSuggestion
mvn clean install
mvn spring-boot:run
```

### Default Port
```
http://localhost:8080/
```

---
