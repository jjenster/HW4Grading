import glob
import os
import csv

section_points_max = [2, 3, 5, 3]

data = {}

unis = [os.path.basename(student_folder).split()[0] for student_folder in glob.glob('submissions_all/*')]
grade_files = [os.path.join(student_folder, 'grade.txt') for student_folder in glob.glob('submissions_all/*')]

for uni, grade_file in zip(unis, grade_files):
  data[uni] = {'uni': uni}

  if os.path.isfile(grade_file):
    with open(grade_file, 'r') as grades_txt:
      csv_reader = csv.reader(grades_txt, delimiter=':')
      grades = list(csv_reader)
      if len(grades) == 0:
        data[uni]['grades'] = 0
        data[uni]['comments'] = 'grade.txt is empty. please check.'
      else:
        data[uni]['grades'] = 25
  else:
    data[uni]['grades'] = 0
    data[uni]['comments'] = 'grade.txt is not present. please check.'

with open('grades-all.csv', 'w') as csv_file:
  writer = csv.DictWriter(csv_file, fieldnames=['uni', 'grades', 'comments'])
  writer.writeheader()
  for value in data.values():
    writer.writerow(value)
