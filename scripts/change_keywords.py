from get_filepaths import *

# Run the above function and store its results in a variable.   
full_file_paths = get_filepaths("/Users/ching-lun/Workspace/ProgrammingExercises")

for filename in full_file_paths:
    if ".java" in filename:
        content = open(filename).read()
        if "implements Exercise" in content:
            content = content.replace("implements Exercise", "extends Exercise")
            
        if "implements LeetCodeExercise" in content:
            content = content.replace("implements LeetCodeExercise", "extends LeetCodeExercise")
            
        if '\t' in content:
            content = content.replace('\t', "    ")
         
        if "private void test()" in content:
            content = content.replace('private void test()', "protected void test()")
             
        if "private void initialize()" in content:
            content = content.replace('private void initialize()', "protected void initialize()")
         
        file = open(filename, 'w')
        file.write(content)
        file.flush()
        file.close()