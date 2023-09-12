import os

repository_directory = os.path.dirname(__file__)
build_directory = os.path.join(repository_directory, "build")
classes_directory = os.path.join(build_directory, "classes")
sources_directory = os.path.join(repository_directory, "sources")

main_class = "TicTacToe"

def log_step(step):
    print(f"    - {step}")

def create_directory(directory):
    try:
        os.makedirs(directory)
    except FileExistsError:
        pass

print(f"Building {main_class}:")
log_step("Creating build directory.")
create_directory(classes_directory)
log_step("Compiling Java classes.")
os.system(f"javac -cp {sources_directory} -d {classes_directory} " +
          f"{os.path.join(sources_directory, main_class)}.java")
log_step("Compressing Jar file.")
os.system(f"jar -cfe {os.path.join(build_directory, main_class)}.jar "+
          f"{main_class} -C {classes_directory} .")
print("All done!")
