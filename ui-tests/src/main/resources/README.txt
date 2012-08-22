How to use Spotify ${project.artifactId} 

version: ${project.version}

Execution:
	extract spotify-${project.artifactId}-${project.version}-bin.tar.gz or zip file
	at the extracted directory> sh ./run
		or
	at the extracted directory> cmd.exe run
		or
	at the extracted directory> java -jar lib/${project.artifactId}-${project.version}.jar

Customization possible with the following system properties passed to the java virtual machine:

	-DTESTDATA_DIR=testdata  <-- use only single / as directory separator
	-DAPP_NAME=Spotify
	-DSIKULI_IMAGE_PATH=images

Example: 
	at the extracted directory> java -DAPP_NAME="C:\Program Files\Spotify\Spotify.exe" -jar lib/${project.artifactId}-${project.version}.jar
