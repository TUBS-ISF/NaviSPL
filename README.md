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

**IMPORTANT NOTE**: DeltaJava is known to be compatible only with Java versions up to Java 1.8! Using a newer version and changing the compilation mode to 1.8 does not help, it requires to install the JDK 1.8 and configure Eclipse accordingly. Additionally, DeltaJava is only compatible with Eclipse versions up to version 2020-12 (find detailed information and instructions on the [DeltaJava homepage](https://deltajava.org/#installation_prepacked))

## Content
* Tutorial : Slides and accompanying material we used in a 2-days introductory workshop with the project participants
* de.tu_bs.cs.isf.jxmapviewer.spl : The implementation of the SPL containing: (Temporal) Feature Model, Constraint Model, Feature-Delta Module Mapping, Delta Modules
* documentation : documentation of the project participants for each evolution step of the SPL
* statistics : some statistics we collected

## How to Generate Variants
* Start eclipse (with DarwinSPL and DeltaJava) with the preconfigured workspace containing the NaviSPL (optimally the ready-to-use version provided in this repo)
* Open the file **NavigationSystem.tfm**
* Activate the **Configuration Mode** button
* Create desired configuration by selecting features (you first have to select a feature with a single click and then perform a double-click - sorry for the clunky implementation)
* Ensure that the seelcted configuration is valid using the **Check Configuration Validity** button
* Click **Derive Variant** button
* Select the mapping model **NavigationSystem.dwmapping** in the same folder as the Feature Model using the **Select a mapping model** button
* Select the **DarwinSPL DeltaJava Variant Deriver** variant deriver in the variant deriver drop-down menu
* Select a target folder for the variant to be generated using the **Select variant target folder** button (optimally select the src folder containing the variant project so that all libraries etc are correctly copied and it can be directly executed through eclipse (relative path to the NaviSPL project = **../de.tu_bs.cs.isf.jxmapviewer.spl.variant/src**))
* Click **Finish**
* If everything went correctly, a notification should appear saying that the variant has been successfully generated.
* You should be able to run the variant by running the generated **NaviApp.java**

## Publications
* Coming (hopefully) soon
