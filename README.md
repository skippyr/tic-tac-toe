# TicTacToe
## About
This repository contains the source code of TicTacToe, a terminal based
tic-tac-toe game that you can play with your friend.

Here is a preview that you can check it out:

![](assets/preview.png)

> [!NOTE]
> The colors used in this game will depend on your terminal emulator's theme. So
> they may look different from the preview in your setup.
>
> For same results, use the same theme: [Flamerial](https://github.com/skippyr/flamerial).
> The font used is [Hack](https://github.com/source-foundry/Hack).

## Installation
### Dependencies
In order to install and run this software properly, the following dependencies
must be installed:

- `git`: it will be used to clone this repository.
- `JDK` (Java Development Kit) and `python3`: they will be used to build the
  source files.
- A font patched by [Nerd Fonts project](https://www.nerdfonts.com/font-downloads):
  it provides the pretty symbols used in the game.

## Procedures
- Clone this repository using `git`.

```bash
git clone --depth=1 https://github.com/skippyr/tic-tac-toe
```

- Access the repository's directory.

```bash
cd tic-tac-toe
```

- Run the `build.py` script using `python3` to build the source files.

```bash
python3 build.py
```

> [!IMPORTANT]
> If you are using Windows, you must ensure first that both `java` and `jar`
> binaries are in your system's `PATH` environment variable, otherwise they
> won't be found and the build will fail.

- After build, you can use `java` to execute the `build/TicTacToe.jar` file and
  starting playing it.

```bash
java -jar build/TicTacToe.jar
```

> [!NOTE]
> Due to Java's nature, that file is cross-plataform and you can execute it in
> any operating system, as long as it has the `JRE` (Java Runtime Environment)
> installed.

## Issues And Contributions
You can use its [issues page](https://github.com/skippyr/tic-tac-toe/issues) to
provide your feedback, to report any issue you are facing or to ask for help.

You can also fork it and send pull requests to be reviewed.

All kinds of contributions, from people of any skill level, is always
appreciated.

## Copyright
This software is under the BSD-3-Clause license. A copy of the license is
bundled with the source code.
