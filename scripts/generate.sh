# copy pre-generated code 

PRE_GENERATED=./generated
TARGET=./target/


if [[ -d $PRE_GENERATED ]]; then
    cp -r --update $PRE_GENERATED/* $TARGET;
fi
