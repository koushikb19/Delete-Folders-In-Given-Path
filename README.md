# Delete-Folders-In-Given-Path

## Create and Delete given internal directories of a folder using java

This program will let you delete the internal directories in a gieven path

### Parameters

It takes two command line parameters

First parameter will be the path you want to search.
Then we have the names of the folders separated with a space.

### Working

It will recursively search all the programs using DFS(Deapth first search)
For each file, it checks if the file is in the given list of folders to delete.
If the file exsists, it will first delete all the content inside the folder and then the folder itself.

