cmake_minimum_required(VERSION 3.5)

project(coord_conv LANGUAGES C)

add_executable(coord_conv main.c)

include(GNUInstallDirs)
install(TARGETS coord_conv
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
