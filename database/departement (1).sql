-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 24 avr. 2023 à 14:40
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `departement`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `matricule` int NOT NULL,
  `mot_de_passe` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`nom`, `prenom`, `matricule`, `mot_de_passe`, `email`) VALUES
('2', '2', 2, '2', 'john.smith@school.ed'),
('Doe', 'Jane', 101, 'password2', 'jane.doe@school.edu'),
('Johnson', 'Mark', 102, 'password3', 'mark.johnson@school.'),
('Williams', 'Mary', 103, 'password4', 'mary.williams@school'),
('Garcia', 'Luis', 104, 'password5', 'luis.garcia@school.e'),
('Brown', 'Samantha', 105, 'password6', 'samantha.brown@schoo'),
('Jones', 'David', 106, 'password7', 'david.jones@school.e'),
('Miller', 'Emily', 107, 'password8', 'emily.miller@school.'),
('Wilson', 'Ryan', 108, 'password9', 'ryan.wilson@school.e'),
('Taylor', 'Olivia', 109, 'password10', 'olivia.taylor@school');

-- --------------------------------------------------------

--
-- Structure de la table `avis`
--

DROP TABLE IF EXISTS `avis`;
CREATE TABLE IF NOT EXISTS `avis` (
  `id_avis` int NOT NULL,
  `objet` varchar(50) NOT NULL,
  `contenu` varchar(200) NOT NULL,
  `date_creation` date NOT NULL,
  PRIMARY KEY (`id_avis`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `demandedocument`
--

DROP TABLE IF EXISTS `demandedocument`;
CREATE TABLE IF NOT EXISTS `demandedocument` (
  `id_demande` int NOT NULL,
  `objet` int NOT NULL,
  `id_etudiant` int NOT NULL,
  `etat` varchar(15) NOT NULL DEFAULT 'incomplet',
  `date_demande` date NOT NULL,
  PRIMARY KEY (`id_demande`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `element_module`
--

DROP TABLE IF EXISTS `element_module`;
CREATE TABLE IF NOT EXISTS `element_module` (
  `id_element` varchar(20) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `id_module` varchar(20) NOT NULL,
  `id_prof` varchar(20) NOT NULL,
  PRIMARY KEY (`id_element`,`nom`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `element_module`
--

INSERT INTO `element_module` (`id_element`, `nom`, `id_module`, `id_prof`) VALUES
('11', 'POO', '1', '123');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `cin` varchar(50) NOT NULL,
  `mot_de_passe` varchar(50) NOT NULL,
  `matricule` int NOT NULL,
  `cne` varchar(20) NOT NULL,
  `genre` varchar(55) NOT NULL,
  `date_naissance` varchar(30) NOT NULL,
  `lieu_naissance` varchar(50) NOT NULL,
  `nationalite` varchar(15) NOT NULL DEFAULT 'marocaine',
  `promotion` varchar(10) DEFAULT '1A',
  `email` varchar(60) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `adresse` varchar(120) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`nom`, `prenom`, `cin`, `mot_de_passe`, `matricule`, `cne`, `genre`, `date_naissance`, `lieu_naissance`, `nationalite`, `promotion`, `email`, `telephone`, `adresse`) VALUES
('1', '1', '1', '1', 1, 'CNE1', '1', '2000-01-01', 'Rabat', 'marocaine', '2A', 'john.smith@student.emi.ac.ma', '0612345678', '1 Avenue Hassan II, Rabat'),
('Bouhaddou', 'Amine', 'J930932', '123456', 100001, 'CNE100001', 'M', '1993-09-15', 'Rabat', 'Marocaine', '3A', 'amine.bouhaddou@student.emi.ac.ma', '0612345678', '1 Rue Hassan II, Rabat'),
('El Fakiri', 'Amina', 'J943022', '123456', 100002, 'CNE100002', 'F', '1994-03-22', 'Casablanca', 'Marocaine', '3A', 'amina.el.fakiri@student.emi.ac.ma', '0623456789', '2 Rue Mohammed V, Casablanca'),
('Haddioui', 'Yassine', 'J938143', '123456', 100003, 'CNE100003', 'M', '1993-08-20', 'Tangier', 'Marocaine', '3A', 'yassine.haddioui@student.emi.ac.ma', '0634567890', '3 Rue Ibn Batouta, Tangier'),
('Lamrani', 'Fatima', 'J951256', '123456', 100004, 'CNE100004', 'F', '1995-12-30', 'Fez', 'Marocaine', '3A', 'fatima.lamrani@student.emi.ac.ma', '0645678901', '4 Rue Ahmed Al Mansour, Fez'),
('Moussaoui', 'Omar', 'J970334', '123456', 100005, 'CNE100005', 'M', '1997-03-20', 'Rabat', 'Marocaine', '2A', 'omar.moussaoui@student.emi.ac.ma', '0656789012', '5 Rue Moulay Ismail, Rabat'),
('Najmi', 'Sara', 'J990443', '123456', 100006, 'CNE100006', 'F', '1999-04-10', 'Marrakech', 'Marocaine', '2A', 'sara.najmi@student.emi.ac.ma', '0667890123', '6 Rue Hassan I, Marrakech'),
('Ouahbi', 'Abdelali', 'J928766', '123456', 100007, 'CNE100007', 'M', '1992-07-05', 'Rabat', 'Marocaine', '3A', 'abdelali.ouahbi@student.emi.ac.ma', '0678901234', '7 Rue Allal Ben Abdellah, Rabat'),
('Rahmouni', 'Meryem', 'J959891', '123456', 100008, 'CNE100008', 'F', '1995-08-01', 'Agadir', 'Marocaine', '3A', 'meryem.rahmouni@student.emi.ac.ma', '0689012345', '8 Rue Hassan II, Agadir');

-- --------------------------------------------------------

--
-- Structure de la table `module_semestre`
--

DROP TABLE IF EXISTS `module_semestre`;
CREATE TABLE IF NOT EXISTS `module_semestre` (
  `id_module` varchar(20) NOT NULL,
  `nom` varchar(30) NOT NULL,
  PRIMARY KEY (`id_module`,`nom`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `module_semestre`
--

INSERT INTO `module_semestre` (`id_module`, `nom`) VALUES
('1', 'Coneption Objet');

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

DROP TABLE IF EXISTS `professeur`;
CREATE TABLE IF NOT EXISTS `professeur` (
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `id_prof` int NOT NULL,
  `mot_de_passe` varchar(20) NOT NULL,
  `CIN` varchar(10) NOT NULL,
  `specialite` varchar(25) NOT NULL,
  `type_contrat` varchar(15) NOT NULL,
  `data_embauche` date NOT NULL,
  `email` varchar(20) NOT NULL,
  `telephone` int NOT NULL,
  `bureau` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`nom`, `prenom`, `id_prof`, `mot_de_passe`, `CIN`, `specialite`, `type_contrat`, `data_embauche`, `email`, `telephone`, `bureau`) VALUES
('Bouzoubaa Karim', '', 123, '', '', '', '', '0000-00-00', '', 0, '');

-- --------------------------------------------------------

--
-- Structure de la table `resultat_element`
--

DROP TABLE IF EXISTS `resultat_element`;
CREATE TABLE IF NOT EXISTS `resultat_element` (
  `id_element` varchar(20) NOT NULL,
  `id_etudiant` varchar(20) NOT NULL,
  `note` double NOT NULL,
  PRIMARY KEY (`id_element`,`id_etudiant`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `resultat_element`
--

INSERT INTO `resultat_element` (`id_element`, `id_etudiant`, `note`) VALUES
('11', '1', 15);

-- --------------------------------------------------------

--
-- Structure de la table `resultat_module`
--

DROP TABLE IF EXISTS `resultat_module`;
CREATE TABLE IF NOT EXISTS `resultat_module` (
  `id_module` varchar(20) NOT NULL,
  `note` float NOT NULL,
  `id_etudiant` int NOT NULL,
  PRIMARY KEY (`id_etudiant`,`id_module`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;