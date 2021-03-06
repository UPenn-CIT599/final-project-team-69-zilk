# Zilk Online Website

This is a pure java based project which mocks the shopping process via the command line. Generally speaking, it has 3 basic functions. 
- Users can login to their account or register a new account
- Users can shop in the website and add/remove products to/from their carts.
- Users can check out and confirm the order

> In order to simplify the whole design and implementation, we assume there are only above mentioned three features with the program. People will be able to pay when they receive the order and they will take responsibility for payment process.

**Tech Stack** 
- Backend: Pure Java
- Data Storage: .txt files
- Interaction: Command Line

## Part1. Work Flow

We will implement 4 modules for the online website. User will first login/register, then purchase in the website and checkout. 
- LoginModule: Validates login/register, updates files when something changed.
- ShoppingModule: Shows all products and allows user to add/remove product to cart
- CheckoutModule: Allows user to confirm the order and updates the orders files.
- SharedData: The integrated data module which manages all data inputs and data outputs. It also contains all in-memory data and provides query API or commit API for other modules. All data related actions will be mocked from reading/writing to files.
(See below chart.)

<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/blob/master/images/FlowChart.PNG"/>

## Part2. Project Structure

The whole project consists of 4 different parts.
- Common: store utility functions
- Components: all different modules
- Entities: store different entities
- Resources: all required resources

<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/blob/master/images/ProjectStructure.PNG"/>

## Part3. Data Model

We adopted simple data model as this is not our top priority for this project.
<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/blob/master/images/DataModel.PNG"/>


## How To Run

- This is a normal Java Project which can be executed from the Eclipse. The executable file is the Zilk/src/main.java.
- All interative commands are from the command line. We are using command line to mock the real website.

<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/blob/master/images/FileLocation.png"/>


### Step 1 - Login Part
There are 2 ways for users to login. If the user is a new user, register option has been provided. If the user is an existing user, this user can log in to the website.

<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/blob/master/images/LoginPart_0.PNG" />


#### Step 1.1 - Register
The whole business logic of Register might be very complex. The below picture shows the all possible options.
- If the username has been occupied, user needs to input again.
- If the username has not been used, user will be able to register and then enter the shopping part after double check.

<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/blob/master/images/LoginPart_1.PNG"/>

#### Step 1.2 - Login
Login will be a little bit complex. Generally speaking, we have provided 3 options:
- User can choose to register a new account if user doesn't have a valid account. Then, user can enter the shopping part.
<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/blob/master/images/LoginPart_2.PNG" />
- User can log out if he/she shows no interest in this part. 
<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/blob/master/images/LoginPart_3.PNG" />
- User can successfully log in the shopping part if the username and password are both correct.
<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/blob/master/images/LoginPart_4.PNG" />

### Step 2 - Shopping Part
The whole shopping part is simple. For demo purpose, we only have 3 products in the website currently. The shopping part has 4 options.
- Add product to the cart. User can type in integer or digits to add product to their carts.
- Remove product from the cart. User can type in negative integer to remove product from their carts.
- Quit from shopping part. User can log out by typing q.
- Enter the Check out stage. User can type in "Check" to check out.
<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/blob/master/images/ShoppingModule.png"/>

### Step 3 - Checkout Part
The checkout part is simplied. As this will be a huge part including the payment and validation, our design and implementation only will support the order sent to mailbox. Users will pay via the order detailed link.
- User can confirm the order or quit from the website.

<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/blob/master/images/Checkout.png"/>

### Others Unit Test
<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/blob/master/images/unit_test.PNG"/>