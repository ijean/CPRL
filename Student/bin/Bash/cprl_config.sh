#!/bin/bash

#
# Configuration settings for the CPRL compiler project.
#
# These settings assume an Eclipse workspace with three separate projects named
# Compiler, CPRL, and CVM.  Class files are placed in a "classes" directory
# rather than the Eclipse default "bin" directory.  The project directory hierarchy
# is as follows:
#  PROJECT_HOME
#   - workspace
#      - Compiler
#      - CPRL
#      - CVM

# set PROJECT_HOME to the directory for your compiler project
PROJECT_HOME=C:\\JMooreMACS\\Teaching\\Compiler

WORKSPACE_HOME=$PROJECT_HOME\\workspace
COMPILER_HOME=$WORKSPACE_HOME\\Compiler
CPRL_HOME=$WORKSPACE_HOME\\CPRL
CVM_HOME=$WORKSPACE_HOME\\CVM

# set CLASSES_DIR to the directory name used for compiled Java classes (e.g., classes or bin)
#CLASSES_DIR=bin
CLASSES_DIR=classes

# Add all project-related class directories to the classpath.
export CLASSPATH="$COMPILER_HOME/$CLASSES_DIR;$CPRL_HOME/$CLASSES_DIR;$CVM_HOME/$CLASSES_DIR;$CLASSPATH"
