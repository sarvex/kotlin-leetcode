Get-ChildItem -Filter *.md -Recurse | Remove-Item

Get-ChildItem -Filter *.kt -Recurse | Rename-Item -NewName { $_.Directory.Name+'.kt'}
Get-ChildItem -Filter *.kt -Recurse | Move-Item -Destination { $_.Directory.Parent.FullName }

Get-ChildItem -Filter *.java -Recurse | Rename-Item -NewName { $_.Directory.Name+'.java'}
Get-ChildItem -Filter *.java -Recurse | Move-Item -Destination { $_.Directory.Parent.FullName }
