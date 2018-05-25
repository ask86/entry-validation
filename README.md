# entry-validation

Operation
•	This application accepts user entries and validates them according to the specifications below.
•	If the data is valid, this app displays the data in a dialog box. Then, when the user clicks OK in the dialog box, the application clears the text fields, so the user can make another entry.
•	If the data is not valid, this app displays a dialog box with an appropriate error message and attempts to move the focus to the text field with the invalid data.
Specifications
•	The Name field is required.
•	The Age field is required and must be a valid integer value.
•	The Sales field is required and must be a valid double value.
•	Create a class named SwingValidator to perform the validation. This class should contain these methods:
boolean isNotEmpty(JTextField field, String fieldName)
boolean isInteger(JTextField field, String fieldName)
boolean isDouble(JTextField field, String fieldName)
