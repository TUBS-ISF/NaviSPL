# NaviSPL

This project contains the Delta-Oriented Software Product Line "NaviSPL" that was developed in a capstone project.

## Setup:
This SPL was realized with the Eclipse plugins **[DarwinSPL](https://gitlab.com/DarwinSPL/DarwinSPL)** as feature modeling notation (problem space) and **[DeltaJava](https://deltajava.org/)** as variability realization mechanism (solution space).
You can set up Eclipse with the resp. plugins via either one of the 2 following approaches

* *easy installation*: Download a [ready-to-use Eclipse 2012-12 installation](https://github.com/TUBS-ISF/NaviSPL/releases/tag/ready-to-use) with DarwinSPL and DeltaJava preconfigured, including a workspace that contains the NaviSPL
  * Download [Windows 64-bit version](https://github.com/TUBS-ISF/NaviSPL/releases/download/ready-to-use/eclipse-deltaj-darwinspl-navigationspl-win64.zip)
  * Download [Linux 64-bit version](https://github.com/TUBS-ISF/NaviSPL/releases/download/ready-to-use/eclipse-deltaj-darwinspl-navigationspl-linux.tar.gz)

* *flexible installation*: Manually set up an Eclipse runtime of your choice (latest tested and working version: [Eclipse 2020-12](https://www.eclipse.org/downloads/packages/release/2020-12/r/eclipse-modeling-tools)) from the plugins' Eclipse update sites (the **order matters**!):
  * install DeltaJava from its update site: https://deltajava.org/update/
  * install DarwinSPL from its update site: https://www.isf.cs.tu-bs.de/data/darwinspl/update/
    * please make sure to install the "*DarwinSPL Variant Generation Plugin for DeltaJava Delta Modules*"!

**IMPORTANT NOTE**: DeltaJava is known to be compatible only with Java versions up to Java 1.8! Using a newer version and changing the compilation mode to 1.8 does not help, it requires to install the JDK 1.8 and configure Eclipse accordingly! Additionally, DeltaJava only works with Eclipse up to version 2020-12 (Find instructions on how to do so on the [DeltaJava homepage](https://deltajava.org/#installation_prepacked) under "Legacy Warning")

## Content
* Tutorial : Slides and accompanying material we used in a 2-days introductory workshop with the project participants
* de.tu_bs.cs.isf.jxmapviewer.spl : The implementation of the SPL containing: (Temporal) Feature Model, Constraint Model, Feature-Delta Module Mapping, Delta Modules
* documentation : documentation of the project participants for each evolution step of the SPL
* statistics : some statistics we collected

## How to Generate Variants
* TBA

## Publications
* Coming (hopefully) soon
