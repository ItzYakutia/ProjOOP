import os
import time

import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import RandomForestClassifier
from sklearn.svm import SVC
from sklearn.linear_model import LogisticRegression
from sklearn.neighbors import KNeighborsClassifier

from imblearn.over_sampling import SMOTE
from imblearn.under_sampling import RandomUnderSampler
RANDOM_STATE = 42
df = pd.read_csv('data/heart_attack_germany.csv')
df.sample(5)
df.info()
df.isna().sum()
df.nunique()
df_ohe = pd.get_dummies(df, drop_first=True)
TARGET = 'Heart_Attack_Incidence'
sns.countplot(df_ohe[TARGET])
df_ohe[TARGET].value_counts(normalize=True)
dtree = DecisionTreeClassifier(random_state=RANDOM_STATE)
X = df_ohe.drop(TARGET, axis=1)
y = df_ohe[TARGET].values
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=RANDOM_STATE, stratify=y)
print(X_train.shape, X_test.shape, y_train.shape, y_test.shape)
dtree.fit(X_train, y_train)
# Step 5: Evaluation of train dataset
print("Evaluating model...")
y_pred = dtree.predict(X_test)
accuracy = accuracy_score(y_test, y_pred)
print(f"Accuracy: {accuracy:.2f}")

cm = confusion_matrix(y_test, y_pred)
sns.heatmap(cm, annot=True, fmt='d', cmap='Blues', xticklabels=['Died', 'Survived'], yticklabels=['Died', 'Survived'])
plt.xlabel('Predicted')
plt.ylabel('Actual')
plt.title('Confusion Matrix')
plt.show()

print("Classification Report:")
print(classification_report(y_test, y_pred))

plt.figure(figsize=(10, 16))
sns.barplot(dtree.feature_importances_, X.columns)
plt.show()
plt.figure(figsize=(10, 16))
sns.barplot(dtree.feature_importances_, X.columns)
plt.show()
knn = KNeighborsClassifier()
logreg = LogisticRegression(random_state=RANDOM_STATE)
svc = SVC(random_state=RANDOM_STATE)
rf = RandomForestClassifier(random_state=RANDOM_STATE)
print("Training KNN model...")
start = time.time()
knn.fit(X_train, y_train)
end = time.time()
print(f"Training took {end - start:.2f} seconds.")
print("Training Logistic Regression model...")
start = time.time()
logreg.fit(X_train, y_train)
end = time.time()
print(f"Training took {end - start:.2f} seconds.")
print("Training RandomForest model...")
start = time.time()
rf.fit(X_train, y_train)
end = time.time()
print(f"Training took {end - start:.2f} seconds.")
# print("Training SVC model...")
# start = time.time()
# svc.fit(X_train, y_train)
# end = time.time()
# print(f"Training took {end - start:.2f} seconds.")
# Step 5: Evaluation of KNN model
print("Evaluating KNN model...")
y_pred = knn.predict(X_test)
accuracy = accuracy_score(y_test, y_pred)
print(f"Accuracy: {accuracy:.2f}")

cm = confusion_matrix(y_test, y_pred)
sns.heatmap(cm, annot=True, fmt='d', cmap='Blues', xticklabels=['NoHearAtack', 'HearAtack'], yticklabels=['NoHearAtack', 'HearAtack'])
plt.xlabel('Predicted')
plt.ylabel('Actual')
plt.title('Confusion Matrix')
plt.show()

print("Classification Report:")
print(classification_report(y_test, y_pred))
# Step 5: Evaluation of logreg model
print("Evaluating logreg model...")
y_pred = logreg.predict(X_test)
print('Finished predicting')
accuracy = accuracy_score(y_test, y_pred)
print(f"Accuracy: {accuracy:.2f}")

cm = confusion_matrix(y_test, y_pred)
sns.heatmap(cm, annot=True, fmt='d', cmap='Blues', xticklabels=['NoHearAtack', 'HearAtack'], yticklabels=['NoHearAtack', 'HearAtack'])
plt.xlabel('Predicted')
plt.ylabel('Actual')
plt.title('Confusion Matrix')
plt.show()

print("Classification Report:")
print(classification_report(y_test, y_pred))
# Step 5: Evaluation of rf model
print("Evaluating rf model...")
y_pred = rf.predict(X_test)
print('Finished predicting')
accuracy = accuracy_score(y_test, y_pred)
print(f"Accuracy: {accuracy:.2f}")

cm = confusion_matrix(y_test, y_pred)
sns.heatmap(cm, annot=True, fmt='d', cmap='Blues', xticklabels=['NoHearAtack', 'HearAtack'], yticklabels=['NoHearAtack', 'HearAtack'])
plt.xlabel('Predicted')
plt.ylabel('Actual')
plt.title('Confusion Matrix')
plt.show()

print("Classification Report:")
print(classification_report(y_test, y_pred))
smote = SMOTE(random_state=RANDOM_STATE)
X_train_resampled, y_train_resampled = smote.fit_resample(X_train, y_train)
sns.countplot(y_train_resampled)
sns.countplot(y_test)
dtree = DecisionTreeClassifier(random_state=RANDOM_STATE)
dtree.fit(X_train_resampled, y_train_resampled)
under_sampler = RandomUnderSampler(random_state=RANDOM_STATE)
X_train_under_sampled, y_train_under_sampled = under_sampler.fit_resample(X_train, y_train)
sns.countplot(y_train_under_sampled)
dtree = DecisionTreeClassifier(random_state=RANDOM_STATE)
dtree.fit(X_train_under_sampled, y_train_under_sampled)
# Step 5: Evaluation of train dataset
print("Evaluating model...")
y_pred = dtree.predict(X_test)
accuracy = accuracy_score(y_test, y_pred)
print(f"Accuracy: {accuracy:.2f}")

cm = confusion_matrix(y_test, y_pred)
sns.heatmap(cm, annot=True, fmt='d', cmap='Blues', xticklabels=['NoHearAtack', 'HearAtack'], yticklabels=['NoHearAtack', 'HearAtack'])
plt.xlabel('Predicted')
plt.ylabel('Actual')
plt.title('Confusion Matrix')
plt.show()

print("Classification Report:")
print(classification_report(y_test, y_pred))
import lightgbm as lgb
from xgboost import XGBClassifier
from sklearn.model_selection import GridSearchCV
import scipy.stats as stats
lgbc = lgb.LGBMClassifier(random_state=RANDOM_STATE)
lgbc.fit(X_train, y_train)
# Step 5: Evaluation of lgbc on test dataset
print("Evaluating model...")
y_pred = lgbc.predict(X_test)
accuracy = accuracy_score(y_test, y_pred)
print(f"Accuracy: {accuracy:.2f}")

cm = confusion_matrix(y_test, y_pred)
sns.heatmap(cm, annot=True, fmt='d', cmap='Blues', xticklabels=['NoHearAtack', 'HearAtack'], yticklabels=['NoHearAtack', 'HearAtack'])
plt.xlabel('Predicted')
plt.ylabel('Actual')
plt.title('Confusion Matrix')
plt.show()

print("Classification Report:")
print(classification_report(y_test, y_pred))
xgb = XGBClassifier(random_state=RANDOM_STATE)
xgb.fit(X_train, y_train)
# Step 5: Evaluation of XGB on test dataset
print("Evaluating model...")
y_pred = xgb.predict(X_test)
accuracy = accuracy_score(y_test, y_pred)
print(f"Accuracy: {accuracy:.2f}")

cm = confusion_matrix(y_test, y_pred)
sns.heatmap(cm, annot=True, fmt='d', cmap='Blues', xticklabels=['NoHearAtack', 'HearAtack'], yticklabels=['NoHearAtack', 'HearAtack'])
plt.xlabel('Predicted')
plt.ylabel('Actual')
plt.title('Confusion Matrix')
plt.show()

print("Classification Report:")
print(classification_report(y_test, y_pred))
params = {
        'min_child_weight': [1, 5, 10],
        'gamma': [0.5, 1, 1.5, 2, 5],
        'subsample': [0.6, 0.8, 1.0],
        'colsample_bytree': [0.6, 0.8, 1.0],
        'max_depth': [3, 4, 5],
        'learning_rate': [0.1, 0.01, 0.001],
        'n_estimators':[50, 100, 150, 200]
        }
params = {
        'max_depth': [3, 5],
        'n_estimators':[150, 200]
        }
# Create the XGBoost model object
xgb_model = XGBClassifier()

# Create the GridSearchCV object
grid_search = GridSearchCV(xgb_model, params, cv=2, scoring='f1', verbose=1, n_jobs=4)

# Fit the GridSearchCV object to the training data
grid_search.fit(X_train, y_train)

# Print the best set of hyperparameters and the corresponding score
print("Best set of hyperparameters: ", grid_search.best_params_)
print("Best score: ", grid_search.best_score_)
xgb_model = XGBClassifier(max_depth=5, n_estimators=200, random_state=RANDOM_STATE)
xgb_model.fit(X_train, y_train)
# Step 5: Evaluation of XGB on test dataset
print("Evaluating model...")
y_pred = xgb_model.predict(X_test)
accuracy = accuracy_score(y_test, y_pred)
print(f"Accuracy: {accuracy:.2f}")

cm = confusion_matrix(y_test, y_pred)
sns.heatmap(cm, annot=True, fmt='d', cmap='Blues', xticklabels=['NoHearAtack', 'HearAtack'], yticklabels=['NoHearAtack', 'HearAtack'])
plt.xlabel('Predicted')
plt.ylabel('Actual')
plt.title('Confusion Matrix')
plt.show()

print("Classification Report:")
print(classification_report(y_test, y_pred))
