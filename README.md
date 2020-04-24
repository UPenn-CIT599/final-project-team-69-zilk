# Zilk Online Website

This is a pure java based project which will mock the shopping process via the command line. Generally speaking, it will have 3 basic functions. 
- Users can login to their account or register a new account
- Users can shop in the website and add/remove products to/from their carts.
- Users can check out and confirm the order

> To simplify the whole design and implementation, we are assuming there are only above mentioned three features. People will pay when they receive the order. The payment system already exist. They will take responsibility for payment process.

**Tech Stack** 
- Backend: Pure Java
- Data Storage: .txt files
- Interaction: Command Line

## Part1. Work Flow

We will implement 4 modules for the online website. User will first login/register, then purchase in the website and checkout. 
- LoginModule: Validate login/register, update files when something changed.
- ShoppingModule: Show all products and allow user to add/remove product to cart
- CheckoutModule: Allow user to confirm the order and update the orders files.
- SharedData: The integrated data module which manages all data inputs and data outputs. It also contains all in-memory data and provides query API or commit API for other modules. All data related actions will be mocked from reading/writing to files.
(See below chart.)

<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/tree/master/images/FlowChart.PNG"/>

## Part2. Project Structure

The whole project consists of 4 different parts.
- Common: store utility functions
- Components: all different modules
- Entities: store different entities
- Resources: all required resources

<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/tree/master/images/ProjectStructure.PNG"/>

## Part3. Data Model

We used very simple data model as this is not our top priority for this project.
<img src="https://github.com/UPenn-CIT599/final-project-team-69-zilk/tree/master/images/DataModel.PNG"/>
