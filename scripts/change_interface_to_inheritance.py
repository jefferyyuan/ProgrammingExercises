import os

def get_filepaths(directory):
    """
    This function will generate the file names in a directory 
    tree by walking the tree either top-down or bottom-up. For each 
    directory in the tree rooted at directory top (including top itself), 
    it yields a 3-tuple (dirpath, dirnames, filenames).
    
    Courtesy of AndiDog
    http://stackoverflow.com/questions/2212643/python-recursive-folder-read
    """
    file_paths = []  # List which will store all of the full filepaths.

    # Walk the tree.
    for root, directories, files in os.walk(directory):
        for filename in files:
            # Join the two strings in order to form the full filepath.
            filepath = os.path.join(root, filename)
            file_paths.append(filepath)  # Add it to the list.

    return file_paths  # Self-explanatory.

# Run the above function and store its results in a variable.   
full_file_paths = get_filepaths("/Users/ching-lun/Workspace/ProgrammingExercises")

for filename in full_file_paths:
    if ".java" in filename:
        content = open(filename).read()
        if "implements Exercise" in content:
            content = content.replace("implements Exercise", "extends Exercise")
            
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