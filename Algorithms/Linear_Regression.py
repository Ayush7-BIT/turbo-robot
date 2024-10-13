Prerequisites
Make sure you have numpy, pandas, and scikit-learn installed. You can install them using pip if you haven't already:

# Code 

import numpy as np
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
import matplotlib.pyplot as plt

# Sample data
# Let's create some sample data for this example
# X: Independent variable (e.g., years of experience)
# y: Dependent variable (e.g., salary)
data = {
    'YearsExperience': [1, 2, 3, 4, 5],
    'Salary': [30000, 35000, 40000, 45000, 50000]
}

df = pd.DataFrame(data)
X = df[['YearsExperience']] 
y = df['Salary']  

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Create a Linear Regression model
model = LinearRegression()

# Fit the model to the training data
model.fit(X_train, y_train)

# Make predictions
predictions = model.predict(X_test)

print("Coefficient (slope):", model.coef_[0])
print("Intercept:", model.intercept_)

# Visualize the results
plt.scatter(X, y, color='blue', label='Data points')
plt.plot(X, model.predict(X), color='red', label='Regression line')
plt.xlabel('Years of Experience')
plt.ylabel('Salary')
plt.title('Linear Regression Example')
plt.legend()
plt.show() 

