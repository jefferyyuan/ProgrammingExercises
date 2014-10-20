from get_filepaths import *

# Run the above function and store its results in a variable.   
full_file_paths = get_filepaths("/Users/ching-lun/Workspace/ProgrammingExercises")

for filename in full_file_paths:
    if ".java" in filename or ".py" in filename:
        content = open(filename).read()
        
        if '\t' in content:
            print filename