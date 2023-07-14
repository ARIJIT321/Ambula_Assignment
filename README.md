
## Description
 This project is a Spring Boot application built with Gradle that provides RESTful APIs:

The application has two types of users: ADMIN and READER. ADMIN users have full access and can perform CRUD operations (Create, Read, Update, Delete), while READER users have restricted access and can only perform GET operations. The API includes two endpoints: "create_data" and "update_data".
## Features
- can add User location
- can get User location
- can updated User location

### Project Setup
1. Clone the repository: `git clone https://github.com/ARIJIT321/Ambula_Assignment.git`
![Screenshot (122)](https://github.com/ARIJIT321/Ambula_Assignment/assets/103993626/caef681a-cd0c-48b4-8d99-8dec8a94dd16)

2. Open any IDE 
2. click on the file
![Screenshot (123)](https://github.com/ARIJIT321/Ambula_Assignment/assets/103993626/7cb50c9b-18c4-402f-8910-d1dd7f001522)

4. click on new (In some IDE there might be an option for import, you can import that way and follow instruction-5)
5. click on import or open project from file System
   - if you import
     i -  choose gradel
![Screenshot (129)](https://github.com/ARIJIT321/Ambula_Assignment/assets/103993626/d4f821aa-caf6-40e9-98a3-bda337a5b152)

     ii - Click on Existing gradel project
![Screenshot (130)](https://github.com/ARIJIT321/Ambula_Assignment/assets/103993626/7082dcc3-047c-4a6e-af56-b95a17f70808)

     iii - chose the folder where you have cloned the project
     ![Screenshot (132)](https://github.com/ARIJIT321/Ambula_Assignment/assets/103993626/4cf82f94-5669-4986-8c6a-acfdf51b30d1)

  - if you choose open from file system
    
    i. Browse the directory and choose the cloned folder
![Screenshot (125)](https://github.com/ARIJIT321/Ambula_Assignment/assets/103993626/19e5f04f-0974-44eb-bb2b-60d4f5abea1d)
![Screenshot (126)](https://github.com/ARIJIT321/Ambula_Assignment/assets/103993626/e9977c78-1e25-4f57-b129-8be0909983e4)


6. click on finish

8. Right-click on "AmbulaApplication"
   
9. Click on Run
10. 10. run as springboot
![Screenshot (134)](https://github.com/ARIJIT321/Ambula_Assignment/assets/103993626/0ad1d2b7-694b-49b1-908d-86f50fb3a3e8)


10. It will start running(It will show something like this)

    ![Screenshot (135)](https://github.com/ARIJIT321/Ambula_Assignment/assets/103993626/48c1ef4f-4261-422f-beb3-86a9b14c6e87)

11. The backend server will start running on `http://localhost:8080`.

12. Now you can test your end points on Postman
    
## API Endpoints
The backend provides the following API endpoints:

- `POST http://localhost:8080/location/create_data`: Add a new UserLocation.
- `Put http://localhost:8080/location/update_data` : update the data
- `GET http://localhost:8080/location/get_users/{n}`: Get all n nearest location .
