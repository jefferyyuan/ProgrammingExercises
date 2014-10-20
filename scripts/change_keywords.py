from get_filepaths import *

import re

# Run the above function and store its results in a variable.   
full_file_paths = get_filepaths("/Users/ching-lun/Workspace/ProgrammingExercises")

for filename in full_file_paths:
    if ".java" in filename:
        content = open(filename).read()
 
        # do stuff here
        if "extends LeetCodeExercise" in content:
            content = content.replace("extends LeetCodeExercise", "extends Exercise")
          
        file = open(filename, 'w')
        file.write(content)
        file.flush()
        file.close()

def remove_tabs(content):
    if '\t' in content:
        content = content.replace('\t', "    ")
